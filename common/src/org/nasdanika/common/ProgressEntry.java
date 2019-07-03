package org.nasdanika.common;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Progress entry storing progress information for subsequent processing.
 * @author Pavel
 *
 */
public class ProgressEntry implements ProgressMonitor {
	
	/**
	 * 
	 * @param totalWork
	 */
	public ProgressEntry(String name, long totalWork, Object... details) {
		this.name = name;		
		this.totalWork = totalWork;
		this.details = details;
		this.start = System.currentTimeMillis();
	}
	
	private String name;
	
	public String getName() {
		return name;
	}

	/**
	 * Work step reported by worked() methods.
	 * @author Pavel
	 *
	 */
	public interface Step {
		
		long getTime();
		
		Status getStatus();
		
		long getWorked();
		
		String getMessage();
		
	}
	
	private Object[] details;
	
	public Object[] getDetails() {
		return details;
	}
	
	private long totalWork;
			
	/**
	 * @return Entry size passed to split() or constructor, not total work reported by worked() calls.
	 */
	public long getTotalWork() {
		return totalWork;
	}
	
	private boolean closed;
	
	private List<ProgressEntry> children = new ArrayList<>();
	
	/**
	 * @return Child progress entries created by split();
	 */
	public List<ProgressEntry> getChildren() {
		return children;
	}
	
	public List<Step> getSteps() {
		return steps;
	}

	private List<Step> steps = new ArrayList<>();
	
	private long start;
	
	private long finish;
	
	/**
	 * @return Time when this entry was created.
	 */
	public long getStart() {
		return start;
	}
	
	/**
	 * @return Time when this entry was closed.
	 */
	public long getFinish() {
		return finish;
	}
	
	@Override
	public void close() {
		closed = true;
	}

	@Override
	public boolean isCancelled() {
		return false;
	}

	@Override
	public ProgressMonitor split(String taskName, long ticks, Object... details) {
		if (isCancelled()) {
			throw new CancellationException();
		}
		if (closed) {
			throw new IllegalStateException("Monitor is closed");
		}
		ProgressEntry child = new ProgressEntry(taskName, ticks, details);
		children.add(child);
		return child;
	}

	@Override
	public void worked(Status status, long work, String progressMessage) {
		if (closed) {
			throw new IllegalStateException("Monitor is closed");
		}
		steps.add(new Step() {

			long now = System.currentTimeMillis();			
			
			@Override
			public long getWorked() {
				return work;
			}
			
			@Override
			public long getTime() {
				return now;
			}
			
			@Override
			public Status getStatus() {
				return status;
			}
			
			@Override
			public String getMessage() {
				return progressMessage;
			}
		});
	}
	
	/**
	 * Outputs to JSON.
	 * @return
	 */
	public JSONObject toJSON() {
		JSONObject ret = new JSONObject();
		ret.put("name", getName());
		ret.put("totalWork", totalWork);
		if (start > 0) {
			ret.put("start", start);
		}
		if (finish > 0) {
			ret.put("finish", finish);
		}

		if (!children.isEmpty()) {
			JSONArray jChildren = new JSONArray();
			children.forEach(child -> jChildren.put(child.toJSON()));
			ret.put("children", jChildren);
		}
		
		if (!steps.isEmpty()) {
			JSONArray jSteps = new JSONArray();
			steps.forEach(we -> {
				JSONObject jwe = new JSONObject();
				jwe.put("status", we.getStatus().name());
				jwe.put("worked", we.getWorked());
				jwe.put("time", we.getTime());
				jwe.put("message", we.getMessage());
				
			});
			ret.put("steps", jSteps);		
		}
		
		return ret;
	}
	
	@Override
	public String toString() {
		return toJSON().toString(4);
	}
	
	/**
	 * Outputs to Map, which can be then used to output to YAML.
	 * @return
	 */
	public Map<String, Object> toMap() {
		Map<String,Object> ret = new LinkedHashMap<>();
		ret.put("name", getName());
		ret.put("totalWork", totalWork);
		if (start > 0) {
			ret.put("start", start);
		}
		if (finish > 0) {
			ret.put("finish", finish);
		}

		if (!children.isEmpty()) {
			List<Map<String, Object>> mChildren = new ArrayList<>();
			children.forEach(child -> mChildren.add(child.toMap()));
			ret.put("children", mChildren);
		}
		
		if (!steps.isEmpty()) {
			List<Map<String, Object>> mSteps = new ArrayList<>();
			steps.forEach(we -> {
				Map<String, Object> mwe = new LinkedHashMap<>();
				mwe.put("status", we.getStatus().name());
				mwe.put("worked", we.getWorked());
				mwe.put("time", we.getTime());
				mwe.put("message", we.getMessage());
			
			});
			ret.put("steps", mSteps);		
		}
		
		return ret;
	}

}
