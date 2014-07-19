package net.java.sip.communicator.impl.protocol.irc;

import net.java.sip.communicator.service.protocol.*;

/**
 * IRC contact implementation.
 * 
 * @author danny
 */
public class ContactIrcImpl
    extends AbstractContact
{
    /**
     * Parent provider.
     */
    private ProtocolProviderServiceIrcImpl provider;
    
    /**
     * Contact id.
     */
    private String id;

    /**
     * Contact's parent group.
     */
    private ContactGroupIrcImpl parentGroup;

    /**
     * Constructor.
     * 
     * @param provider Protocol provider service instance.
     * @param id Contact id.
     */
    public ContactIrcImpl(ProtocolProviderServiceIrcImpl provider, String id,
        ContactGroupIrcImpl parentGroup)
    {
        if (provider == null)
            throw new IllegalArgumentException("provider cannot be null");
        this.provider = provider;
        if (id == null)
            throw new IllegalArgumentException("id cannot be null");
        this.id = id;
        if (parentGroup == null)
            throw new IllegalArgumentException("parentGroup cannot be null");
        this.parentGroup = parentGroup;
    }

    /**
     * Get contact id (a.k.a. address)
     * 
     * @return returns id
     */
    @Override
    public String getAddress()
    {
        return this.id;
    }

    /**
     * Get contact display name.
     * 
     * @return returns display name
     */
    @Override
    public String getDisplayName()
    {
        return this.id;
    }

    /**
     * Get contact image (avatar)
     * 
     * @return returns image data
     */
    @Override
    public byte[] getImage()
    {
        return null;
    }

    /**
     * Get presence status.
     * 
     * @return returns presence status
     */
    @Override
    public PresenceStatus getPresenceStatus()
    {
        return IrcStatusEnum.ONLINE;
    }

    /**
     * Get parent contact group.
     * 
     * @return returns parent contact group
     */
    @Override
    public ContactGroup getParentContactGroup()
    {
        return this.parentGroup;
    }

    /**
     * Get protocol provider service.
     * 
     * @return returns IRC protocol provider service.
     */
    @Override
    public ProtocolProviderService getProtocolProvider()
    {
        return this.provider;
    }

    /**
     * Is persistent contact.
     * 
     * @return Returns true if contact is persistent, or false otherwise.
     */
    @Override
    public boolean isPersistent()
    {
        // TODO implement notion of persistence based on whether or not the nick
        // name is registered on the IRC network, for NickServ.
        return false;
    }

    /**
     * Is contact resolved.
     * 
     * @return Returns true if contact is resolved, or false otherwise.
     */
    @Override
    public boolean isResolved()
    {
        // TODO implement resolved status based on whether or not the nick name
        // is registered and the nick is currently "active" according to the
        // server, i.e. NickServ.
        // For now, we consider the contact unresolved ...
        return false;
    }

    /**
     * Get persistent data (if any).
     * 
     * @return returns persistent data if available or null otherwise.
     */
    @Override
    public String getPersistentData()
    {
        // TODO this could retrieve some whois/contact data from NickServ, since
        // the "persistent contact" is registered.
        return null;
    }

    /**
     * Get status message.
     * 
     * @return returns status message
     */
    @Override
    public String getStatusMessage()
    {
        return null;
    }

}
