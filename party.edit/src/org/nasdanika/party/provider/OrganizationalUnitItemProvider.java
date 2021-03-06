/**
 */
package org.nasdanika.party.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.nasdanika.emf.edit.EReferenceItemProvider;
import org.nasdanika.party.OrganizationalUnit;
import org.nasdanika.party.PartyPackage;

/**
 * This is the item provider adapter for a {@link org.nasdanika.party.OrganizationalUnit} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class OrganizationalUnitItemProvider extends PartyItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationalUnitItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}
	
	/**
	 * Called from getChildren(), adds EReferenceItemProvider children.
	 * @param children
	 */
	@Override
	protected void addEReferenceItemProviderChildren(Object object, Collection<EReferenceItemProvider> children) {
		super.addEReferenceItemProviderChildren(object, children);
		children.add(new EReferenceItemProvider(this, (EObject) object, PartyPackage.Literals.ORGANIZATIONAL_UNIT__ORGANIZATIONAL_UNITS));
		children.add(new EReferenceItemProvider(this, (EObject) object, PartyPackage.Literals.ORGANIZATIONAL_UNIT__ROLES));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			// Added as EReferenceItemProvider
//			childrenFeatures.add(PartyPackage.Literals.ORGANIZATIONAL_UNIT__ORGANIZATIONAL_UNITS);
//			childrenFeatures.add(PartyPackage.Literals.ORGANIZATIONAL_UNIT__ROLES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns OrganizationalUnit.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/OrganizationalUnit.png"));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = ((OrganizationalUnit)object).getTitle();
		return label == null || label.length() == 0 ? getString("_UI_OrganizationalUnit_type") : label;
	}


	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(OrganizationalUnit.class)) {
			case PartyPackage.ORGANIZATIONAL_UNIT__ORGANIZATIONAL_UNITS:
			case PartyPackage.ORGANIZATIONAL_UNIT__ROLES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
		
		// --- Org units ---
		for (EObject resource: org.nasdanika.party.util.Activator.ORG_UNITS_PALETTE.getElements()) {
			newChildDescriptors.add(createChildParameter(PartyPackage.Literals.ORGANIZATIONAL_UNIT__ORGANIZATIONAL_UNITS, resource));						
		}		

		// --- Roles ---
		for (EObject resource: org.nasdanika.party.util.Activator.ROLES_PALETTE.getElements()) {
			newChildDescriptors.add(createChildParameter(PartyPackage.Literals.ORGANIZATIONAL_UNIT__ROLES, resource));						
		}		

	}

}
