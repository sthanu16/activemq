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
package org.apache.activemq.transport.https;

import org.apache.activemq.transport.http.HttpTransportServer;
import org.mortbay.jetty.security.SslSocketConnector;

import java.net.URI;

public class HttpsTransportServer extends HttpTransportServer {

	private String keyPassword = System.getProperty( "javax.net.ssl.keyPassword" );
	private String keyStorePassword = System.getProperty( "javax.net.ssl.keyStorePassword" );
	private String keyStore = System.getProperty( "javax.net.ssl.keyStore" );
	private String keyStoreType = null;
	private String certificateAlgorithm = null;
	private String protocol = null;
	
	public HttpsTransportServer( URI uri ) {
		super( uri );
	}

	public void start() throws Exception {
		SslSocketConnector sslConnector = new SslSocketConnector();
		sslConnector.setKeystore( keyStore );
		sslConnector.setPassword( keyStorePassword );
		// if the keyPassword hasn't been set, default it to the
		// key store password
		if ( keyPassword == null ) {
			sslConnector.setKeyPassword( keyStorePassword );	
		}
		if ( keyStoreType != null ) {
			sslConnector.setKeystoreType( keyStoreType );
		}
		if ( certificateAlgorithm != null ) {
			sslConnector.setAlgorithm( certificateAlgorithm );
		}
		if ( protocol != null ) {
			sslConnector.setProtocol( protocol );
		}
		
        setConnector(sslConnector);
		
		super.start();
	}
	
	// Properties
	//--------------------------------------------------------------------------------
	
	public String getCertificateAlgorithm() {
		return certificateAlgorithm;
	}

	public void setCertificateAlgorithm( String certificateAlgorithm ) {
		this.certificateAlgorithm = certificateAlgorithm;
	}

	public String getKeyStore() {
		return keyStore;
	}

	public void setKeyStore( String keyStore ) {
		this.keyStore = keyStore;
	}

	public String getKeyPassword() {
		return keyPassword;
	}

	public void setKeyPassword( String keyPassword ) {
		this.keyPassword = keyPassword;
	}

	public String getKeyStoreType() {
		return keyStoreType;
	}

	public void setKeyStoreType( String keyStoreType ) {
		this.keyStoreType = keyStoreType;
	}

	public String getKeyStorePassword() {
		return keyStorePassword;
	}

	public void setKeyStorePassword( String keyStorePassword ) {
		this.keyStorePassword = keyStorePassword;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol( String protocol ) {
		this.protocol = protocol;
	}

}
