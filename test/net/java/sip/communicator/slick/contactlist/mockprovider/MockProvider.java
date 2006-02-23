/*
 * SIP Communicator, the OpenSource Java VoIP and Instant Messaging client.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */
package net.java.sip.communicator.slick.contactlist.mockprovider;

import java.util.*;

import net.java.sip.communicator.service.protocol.*;
import net.java.sip.communicator.service.protocol.event.*;

/**
 * A mock protocol provider implementation that comes with a single operation
 * set (OperationSetPersistentPresence) for use by the MetaContactListSlcik.
 *
 * @author Emil Ivov
 */
public class MockProvider
    implements ProtocolProviderService
{
    /**
     * The SIP Communicator Mock Protocol name.
     */
    private static final String PROTO_NAME = "TheSipCommMockProtocol";

    /**
     * The operation sets that our mock provider supports.
     */
    private Hashtable supportedOperationSets  = new Hashtable();

    /**
     * The presence operation set supported by the mock provider.
     */
    private MockPersistentPresenceOperationSet mockPresOpSet = null;

    /**
     * Creates an instance of this mockprovider with a ttsupportedOperationSet-s
     * map set to contain a single persistent presence operation set.
     */
    public MockProvider()
    {
        mockPresOpSet = new MockPersistentPresenceOperationSet(this);
        this.supportedOperationSets.put(
                OperationSetPersistentPresence.class.getName(),
                mockPresOpSet);
    }

    /**
     * Mock implementation of the corresponding ProtocolProviderService method.
     *
     * @param listener a param.
     */
    public void addRegistrationStateChangeListener(
        RegistrationStateChangeListener listener)
    {
    }

    /**
     * Mock implementation of the corresponding ProtocolProviderService method.
     *
     * @return a String describing this mock protocol.
     */
    public String getProtocolName()
    {
        return PROTO_NAME;
    }

    /**
     * Mock implementation of the corresponding ProtocolProviderService method.
     *
     * @return a Registered RegistrationState.
     */
    public RegistrationState getRegistrationState()
    {
        return RegistrationState.REGISTERED;
    }

    /**
     * Returns an array containing all operation sets supported by the
     * current implementation.
     *
     * @return a java.util.Map containing instance of all supported
     *   operation sets mapped against their class names (e.g.
     *   OperationSetPresence.class.getName()) .
     */
    public Map getSupportedOperationSets()
    {
        return this.supportedOperationSets;
    }

    /**
     * Mock implementation of the corresponding ProtocolProviderService method.
     *
     * @return always true.
     */
    public boolean isRegistered()
    {
        return true;
    }

    /**
     * Mock implementation of the corresponding ProtocolProviderService method.
     *
     * @param authority a dummy param
     */
    public void register(SecurityAuthority authority)
    {

    }

    /**
     * Mock implementation of the corresponding ProtocolProviderService method.
     *
     * @param listener a dummy param.
     */
    public void removeRegistrationStateChangeListener(
        RegistrationStateChangeListener listener)
    {

    }

    /**
     * Mock implementation of the corresponding ProtocolProviderService method.
     */
    public void shutdown()
    {
    }

    /**
     * Mock implementation of the corresponding ProtocolProviderService method.
     */
    public void unregister()
    {
    }
}
