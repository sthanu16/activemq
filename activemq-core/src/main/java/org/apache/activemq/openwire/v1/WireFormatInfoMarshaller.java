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
 * Marshalling code for Open Wire Format for WireFormatInfoMarshaller
 *
 *
 * NOTE!: This file is auto generated - do not modify!
 *        if you need to make a change, please see the modify the groovy scripts in the
 *        under src/gram/script and then use maven openwire:generate to regenerate 
 *        this file.
 *
 * @version $Revision$
 */
public class WireFormatInfoMarshaller extends BaseDataStreamMarshaller {

    /**
     * Return the type of Data Structure we marshal
     * @return short representation of the type data structure
     */
    public byte getDataStructureType() {
        return WireFormatInfo.DATA_STRUCTURE_TYPE;
    }
    
    /**
     * @return a new object instance
     */
    public DataStructure createObject() {
        return new WireFormatInfo();
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

        WireFormatInfo info = (WireFormatInfo)o;
        info.setMagic(tightUnmarshalConstByteArray(dataIn, bs, 8));
        info.setVersion(dataIn.readInt());
        info.setCacheEnabled(bs.readBoolean());
        info.setStackTraceEnabled(bs.readBoolean());
        info.setTcpNoDelayEnabled(bs.readBoolean());
        info.setPrefixPacketSize(bs.readBoolean());
        info.setTightEncodingEnabled(bs.readBoolean());

    }


    /**
     * Write the booleans that this object uses to a BooleanStream
     */
    public int tightMarshal1(OpenWireFormat wireFormat, Object o, BooleanStream bs) throws IOException {

        WireFormatInfo info = (WireFormatInfo)o;

        int rc = super.tightMarshal1(wireFormat, o, bs);
    rc += tightMarshalConstByteArray1(info.getMagic(), bs, 8);
        bs.writeBoolean(info.isCacheEnabled());
    bs.writeBoolean(info.isStackTraceEnabled());
    bs.writeBoolean(info.isTcpNoDelayEnabled());
    bs.writeBoolean(info.isPrefixPacketSize());
    bs.writeBoolean(info.isTightEncodingEnabled());

        return rc + 4;
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

        WireFormatInfo info = (WireFormatInfo)o;
    tightMarshalConstByteArray2(info.getMagic(), dataOut, bs, 8);
    dataOut.writeInt(info.getVersion());
    bs.readBoolean();
    bs.readBoolean();
    bs.readBoolean();
    bs.readBoolean();
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

        WireFormatInfo info = (WireFormatInfo)o;
        info.setMagic(looseUnmarshalConstByteArray(dataIn, 8));
        info.setVersion(dataIn.readInt());
        info.setCacheEnabled(dataIn.readBoolean());
        info.setStackTraceEnabled(dataIn.readBoolean());
        info.setTcpNoDelayEnabled(dataIn.readBoolean());
        info.setPrefixPacketSize(dataIn.readBoolean());
        info.setTightEncodingEnabled(dataIn.readBoolean());

    }


    /**
     * Write the booleans that this object uses to a BooleanStream
     */
    public void looseMarshal(OpenWireFormat wireFormat, Object o, DataOutputStream dataOut) throws IOException {

        WireFormatInfo info = (WireFormatInfo)o;

        super.looseMarshal(wireFormat, o, dataOut);
    looseMarshalConstByteArray(wireFormat, info.getMagic(), dataOut, 8);
    dataOut.writeInt(info.getVersion());
    dataOut.writeBoolean(info.isCacheEnabled());
    dataOut.writeBoolean(info.isStackTraceEnabled());
    dataOut.writeBoolean(info.isTcpNoDelayEnabled());
    dataOut.writeBoolean(info.isPrefixPacketSize());
    dataOut.writeBoolean(info.isTightEncodingEnabled());

    }
}
