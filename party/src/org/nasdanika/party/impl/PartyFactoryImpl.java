/**
 */
package org.nasdanika.party.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.nasdanika.party.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PartyFactoryImpl extends EFactoryImpl implements PartyFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PartyFactory init() {
		try {
			PartyFactory thePartyFactory = (PartyFactory)EPackage.Registry.INSTANCE.getEFactory(PartyPackage.eNS_URI);
			if (thePartyFactory != null) {
				return thePartyFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PartyFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartyFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PartyPackage.DIRECTORY: return createDirectory();
			case PartyPackage.ORGANIZATIONAL_UNIT: return createOrganizationalUnit();
			case PartyPackage.ORGANIZATIONAL_UNIT_REFERENCE: return createOrganizationalUnitReference();
			case PartyPackage.ROLE: return createRole();
			case PartyPackage.ORGANIZATION: return createOrganization();
			case PartyPackage.MEMBER_DIRECTORY: return createMemberDirectory();
			case PartyPackage.MEMBER: return createMember();
			case PartyPackage.PERSON: return createPerson();
			case PartyPackage.CONTACT_METHOD: return createContactMethod();
			case PartyPackage.EMAIL: return createEMail();
			case PartyPackage.PHONE: return createPhone();
			case PartyPackage.POSTAL_ADDRESS: return createPostalAddress();
			case PartyPackage.WEB_ADDRESS: return createWebAddress();
			case PartyPackage.RESOURCE_CATEGORY: return createResourceCategory();
			case PartyPackage.MARKDOWN_TEXT: return createMarkdownText();
			case PartyPackage.MARKDOWN_RESOURCE: return createMarkdownResource();
			case PartyPackage.RESOURCE_REFERENCE: return createResourceReference();
			case PartyPackage.HTML_TEXT: return createHtmlText();
			case PartyPackage.HTML_RESOURCE: return createHtmlResource();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Directory createDirectory() {
		DirectoryImpl directory = new DirectoryImpl();
		return directory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OrganizationalUnit createOrganizationalUnit() {
		OrganizationalUnitImpl organizationalUnit = new OrganizationalUnitImpl();
		return organizationalUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OrganizationalUnitReference createOrganizationalUnitReference() {
		OrganizationalUnitReferenceImpl organizationalUnitReference = new OrganizationalUnitReferenceImpl();
		return organizationalUnitReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Role createRole() {
		RoleImpl role = new RoleImpl();
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Organization createOrganization() {
		OrganizationImpl organization = new OrganizationImpl();
		return organization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MemberDirectory createMemberDirectory() {
		MemberDirectoryImpl memberDirectory = new MemberDirectoryImpl();
		return memberDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Member createMember() {
		MemberImpl member = new MemberImpl();
		return member;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Person createPerson() {
		PersonImpl person = new PersonImpl();
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ContactMethod createContactMethod() {
		ContactMethodImpl contactMethod = new ContactMethodImpl();
		return contactMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMail createEMail() {
		EMailImpl eMail = new EMailImpl();
		return eMail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Phone createPhone() {
		PhoneImpl phone = new PhoneImpl();
		return phone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PostalAddress createPostalAddress() {
		PostalAddressImpl postalAddress = new PostalAddressImpl();
		return postalAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WebAddress createWebAddress() {
		WebAddressImpl webAddress = new WebAddressImpl();
		return webAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceCategory createResourceCategory() {
		ResourceCategoryImpl resourceCategory = new ResourceCategoryImpl();
		return resourceCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MarkdownText createMarkdownText() {
		MarkdownTextImpl markdownText = new MarkdownTextImpl();
		return markdownText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MarkdownResource createMarkdownResource() {
		MarkdownResourceImpl markdownResource = new MarkdownResourceImpl();
		return markdownResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceReference createResourceReference() {
		ResourceReferenceImpl resourceReference = new ResourceReferenceImpl();
		return resourceReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HtmlText createHtmlText() {
		HtmlTextImpl htmlText = new HtmlTextImpl();
		return htmlText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HtmlResource createHtmlResource() {
		HtmlResourceImpl htmlResource = new HtmlResourceImpl();
		return htmlResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PartyPackage getPartyPackage() {
		return (PartyPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PartyPackage getPackage() {
		return PartyPackage.eINSTANCE;
	}

} //PartyFactoryImpl
