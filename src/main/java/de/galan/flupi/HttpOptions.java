package de.galan.flupi;

import de.galan.commons.time.HumanTime;
import de.galan.flupi.proxy.CommonProxy;


/**
 * Additional behaviour options for the HttpClient
 * 
 * @author daniel
 */
public class HttpOptions {

	private static final long DEFAULT_TIMEOUT = HumanTime.dehumanizeTime("5s");

	private Long timeout;
	private String authorizationUsername;
	private String authorizationPassword;
	private CommonProxy proxy;
	private Long retriesCount;
	private Long timeBetweenRetries;
	private Boolean followRedirects = true;
	private Boolean timeoutThread = false;


	public Long getTimeout() {
		return timeout == null ? DEFAULT_TIMEOUT : timeout;
	}


	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}


	public CommonProxy getProxy() {
		return proxy;
	}


	public void enableProxy(CommonProxy commonProxy) {
		proxy = commonProxy;
	}


	public boolean isProxyEnabled() {
		return proxy != null;
	}


	public long getRetriesCount() {
		return retriesCount == null ? 0L : retriesCount;
	}


	public Long getTimeBetweenRetries() {
		return timeBetweenRetries;
	}


	public void enableRetries(Long retries, Long timeBetween) {
		if (retries != null) {
			retriesCount = retries;
			timeBetweenRetries = timeBetween;
		}
	}


	public void enableRetries(Long retries, String timeBetween) {
		enableRetries(retries, HumanTime.dehumanizeTime(timeBetween));
	}


	public Boolean getFollowRedirects() {
		return followRedirects;
	}


	public void enableFollowRedirects(Boolean follow) {
		followRedirects = follow;
	}


	public Boolean getTimeoutThread() {
		return timeoutThread;
	}


	public void enableTimeoutThread(Boolean thread) {
		timeoutThread = thread;
	}


	public void enableAuthorization(String username, String password) {
		authorizationUsername = username;
		authorizationPassword = password;
	}


	public String getAuthorizationUsername() {
		return authorizationUsername;
	}


	public String getAuthorizationPassword() {
		return authorizationPassword;
	}

}