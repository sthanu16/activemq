/**
 *
 * Copyright 2005-2006 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.activemq.openwire.v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.apache.activemq.openwire.*;
import org.apache.activemq.command.*;


/**
 * Marshalling code for Open Wire Format for ConsumerInfoMarshaller
 *
 *
 * NOTE!: This file is auto generated - do not modify!
 *        if you need to make a change, please see the modify the groovy scripts in the
 *        under src/gram/script and then use maven openwire:generate to regenerate 
 *        this file.
 *
 * @version $Revision$
 */
public class ConsumerInfoMarshaller extends BaseCommandMarshaller {

    /**
     * Return the type of Data Structure we marshal
     * @return short representation of the type data structure
     */
    public byte getDataStructureType() {
        return ConsumerInfo.DATA_STRUCTURE_TYPE;
    }
    
    /**
     * @return a new object instance
     */
    public DataStructure createObject() {
        return new ConsumerInfo();
    }

    /**
     * Un-marshal an object instance from the data input stream
     *
     * @param o the object to un-marshal
     * @param dataIn the data input stream to build the object from
     * @throws IOException
     */
    public void tightUnmarshal(OpenWireFormat wireFormat, Object o, DataInputStream dataIn, BooleanStream bs) throws IOException {
        super.tightUnmarshal(wireFormat, o, dataIn, bs);

        ConsumerInfo info = (ConsumerInfo)o;
        info.setConsumerId((ConsumerId) tightUnmarsalCachedObject(wireFormat, dataIn, bs));
        info.setBrowser(bs.readBoolean());
        info.setDestination((ActiveMQDestination) tightUnmarsalCachedObject(wireFormat, dataIn, bs));
        info.setPrefetchSize(dataIn.readInt());
        info.setDispatchAsync(bs.readBoolean());
        info.setSelector(tightUnmarshalString(dataIn, bs));
        info.setSubcriptionName(tightUnmarshalString(dataIn, bs));
        info.setNoLocal(bs.readBoolean());
        info.setExclusive(bs.readBoolean());
        info.setRetroactive(bs.readBoolean());
        info.setPriority(dataIn.readByte());

        if (bs.readBoolean()) {
            short size = dataIn.readShort();
            BrokerId value[] = new BrokerId[size];
            for( int i=0; i < size; i++ ) {
                value[i] = (BrokerId) tightUnmarsalNestedObject(wireFormat,dataIn, bs);
            }
            info.setBrokerPath(value);
        }
        else {
            info.setBrokerPath(null);
        }
        info.setNetworkSubscription(bs.readBoolean());

    }


    /**
     * Write the booleans that this object uses to a BooleanStream
     */
    public int tightMarshal1(OpenWireFormat wireFormat, Object o, BooleanStream bs) throws IOException {

        ConsumerInfo info = (ConsumerInfo)o;

        int rc = super.tightMarshal1(wireFormat, o, bs);
    rc += tightMarshalCachedObject1(wireFormat, info.getConsumerId(), bs);
    bs.writeBoolean(info.isBrowser());
    rc += tightMarshalCachedObject1(wireFormat, info.getDestination(), bs);
        bs.writeBoolean(info.isDispatchAsync());
    rc += tightMarshalString1(info.getSelector(), bs);
    rc += tightMarshalString1(info.getSubcriptionName(), bs);
    bs.writeBoolean(info.isNoLocal());
    bs.writeBoolean(info.isExclusive());
    bs.writeBoolean(info.isRetroactive());
        rc += tightMarshalObjectArray1(wireFormat, info.getBrokerPath(), bs);
    bs.writeBoolean(info.isNetworkSubscription());

        return rc + 5;
    }

    /**
     * Write a object instance to data output stream
     *
     * @param o the instance to be marshaled
     * @param dataOut the output stream
     * @throws IOException thrown if an error occurs
     */
    public void tightMarshal2(OpenWireFormat wireFormat, Object o, DataOutputStream dataOut, BooleanStream bs) throws IOException {
        super.tightMarshal2(wireFormat, o, dataOut, bs);

        ConsumerInfo info = (ConsumerInfo)o;
    tightMarshalCachedObject2(wireFormat, info.getConsumerId(), dataOut, bs);
    bs.readBoolean();
    tightMarshalCachedObject2(wireFormat, info.getDestination(), dataOut, bs);
    dataOut.writeInt(info.getPrefetchSize());
    bs.readBoolean();
    tightMarshalString2(info.getSelector(), dataOut, bs);
    tightMarshalString2(info.getSubcriptionName(), dataOut, bs);
    bs.readBoolean();
    bs.readBoolean();
    bs.readBoolean();
    dataOut.writeByte(info.getPriority());
    tightMarshalObjectArray2(wireFormat, info.getBrokerPath(), dataOut, bs);
    bs.readBoolean();

    }

    /**
     * Un-marshal an object instance from the data input stream
     *
     * @param o the object to un-marshal
     * @param dataIn the data input stream to build the object from
     * @throws IOException
     */
    public void looseUnmarshal(OpenWireFormat wireFormat, Object o, DataInputStream dataIn) throws IOException {
        super.looseUnmarshal(wireFormat, o, dataIn);

        ConsumerInfo info = (ConsumerInfo)o;
        info.setConsumerId((ConsumerId) looseUnmarsalCachedObject(wireFormat, dataIn));
        info.setBrowser(dataIn.readBoolean());
        info.setDestination((ActiveMQDestination) looseUnmarsalCachedObject(wireFormat, dataIn));
        info.setPrefetchSize(dataIn.readInt());
        info.setDispatchAsync(dataIn.readBoolean());
        info.setSelector(looseUnmarshalString(dataIn));
        info.setSubcriptionName(looseUnmarshalString(dataIn));
        info.setNoLocal(dataIn.readBoolean());
        info.setExclusive(dataIn.readBoolean());
        info.setRetroactive(dataIn.readBoolean());
        info.setPriority(dataIn.readByte());

        if (dataIn.readBoolean()) {
            short size = dataIn.readShort();
            BrokerId value[] = new BrokerId[size];
            for( int i=0; i < size; i++ ) {
                value[i] = (BrokerId) looseUnmarsalNestedObject(wireFormat,dataIn);
            }
            info.setBrokerPath(value);
        }
        else {
            info.setBrokerPath(null);
        }
        info.setNetworkSubscription(dataIn.readBoolean());

    }


    /**
     * Write the booleans that this object uses to a BooleanStream
     */
    public void looseMarshal(OpenWireFormat wireFormat, Object o, DataOutputStream dataOut) throws IOException {

        ConsumerInfo info = (ConsumerInfo)o;

        super.looseMarshal(wireFormat, o, dataOut);
    looseMarshalCachedObject(wireFormat, info.getConsumerId(), dataOut);
    dataOut.writeBoolean(info.isBrowser());
    looseMarshalCachedObject(wireFormat, info.getDestination(), dataOut);
    dataOut.writeInt(info.getPrefetchSize());
    dataOut.writeBoolean(info.isDispatchAsync());
    looseMarshalString(info.getSelector(), dataOut);
    looseMarshalString(info.getSubcriptionName(), dataOut);
    dataOut.writeBoolean(info.isNoLocal());
    dataOut.writeBoolean(info.isExclusive());
    dataOut.writeBoolean(info.isRetroactive());
    dataOut.writeByte(info.getPriority());
    looseMarshalObjectArray(wireFormat, info.getBrokerPath(), dataOut);
    dataOut.writeBoolean(info.isNetworkSubscription());

    }
}
