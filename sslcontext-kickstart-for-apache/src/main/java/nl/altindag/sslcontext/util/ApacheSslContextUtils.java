package nl.altindag.sslcontext.util;

import nl.altindag.sslcontext.SSLFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;

public final class ApacheSslContextUtils {

    private ApacheSslContextUtils() {}

    /**
     * @deprecated Will be removed with version 6.0.0, please use {@link ApacheSslContextUtils#toSocketFactory(SSLFactory)}
     */
    @Deprecated
    public static LayeredConnectionSocketFactory toLayeredConnectionSocketFactory(SSLFactory sslFactory) {
        return toSocketFactory(sslFactory);
    }

    public static LayeredConnectionSocketFactory toSocketFactory(SSLFactory sslFactory) {
        return new SSLConnectionSocketFactory(
                sslFactory.getSslContext(),
                sslFactory.getSslParameters().getProtocols(),
                sslFactory.getSslParameters().getCipherSuites(),
                sslFactory.getHostnameVerifier()
        );
    }

}
