//
//
// Copyright 2005-2006 The Apache Software Foundation
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

using System;
using System.Collections;
using System.IO;

using OpenWire.Client;
using OpenWire.Client.Commands;
using OpenWire.Client.Core;
using OpenWire.Client.IO;

namespace OpenWire.Client.IO
{
  //
  //  Marshalling code for Open Wire Format for WireFormatInfo
  //
  //
  //  NOTE!: This file is autogenerated - do not modify!
  //        if you need to make a change, please see the Groovy scripts in the
  //        activemq-core module
  //
  public class WireFormatInfoMarshaller : BaseDataStreamMarshaller
  {


    public override DataStructure CreateObject() 
    {
        return new WireFormatInfo();
    }

    public override byte GetDataStructureType() 
    {
        return WireFormatInfo.ID_WireFormatInfo;
    }

    // 
    // Un-marshal an object instance from the data input stream
    // 
    public override void TightUnmarshal(OpenWireFormat wireFormat, Object o, BinaryReader dataIn, BooleanStream bs) 
    {
        base.TightUnmarshal(wireFormat, o, dataIn, bs);

        WireFormatInfo info = (WireFormatInfo)o;
        info.Magic = ReadBytes(dataIn, 8);
        info.Version = BaseDataStreamMarshaller.ReadInt(dataIn);
        info.CacheEnabled = bs.ReadBoolean();
        info.StackTraceEnabled = bs.ReadBoolean();
        info.TcpNoDelayEnabled = bs.ReadBoolean();
        info.PrefixPacketSize = bs.ReadBoolean();
        info.TightEncodingEnabled = bs.ReadBoolean();

    }


    //
    // Write the booleans that this object uses to a BooleanStream
    //
    public override int TightMarshal1(OpenWireFormat wireFormat, Object o, BooleanStream bs) {
        WireFormatInfo info = (WireFormatInfo)o;

        int rc = base.TightMarshal1(wireFormat, info, bs);
            bs.WriteBoolean(info.CacheEnabled);
    bs.WriteBoolean(info.StackTraceEnabled);
    bs.WriteBoolean(info.TcpNoDelayEnabled);
    bs.WriteBoolean(info.PrefixPacketSize);
    bs.WriteBoolean(info.TightEncodingEnabled);

        return rc + 12;
    }

    // 
    // Write a object instance to data output stream
    //
    public override void TightMarshal2(OpenWireFormat wireFormat, Object o, BinaryWriter dataOut, BooleanStream bs) {
        base.TightMarshal2(wireFormat, o, dataOut, bs);

        WireFormatInfo info = (WireFormatInfo)o;
    dataOut.Write(info.Magic, 0, 8);
    BaseDataStreamMarshaller.WriteInt(info.Version, dataOut);
    bs.ReadBoolean();
    bs.ReadBoolean();
    bs.ReadBoolean();
    bs.ReadBoolean();
    bs.ReadBoolean();

    }
  }
}
