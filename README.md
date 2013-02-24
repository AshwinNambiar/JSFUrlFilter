JSFUrlFilter
============

JSFUrlFilter is a framework to provide friendly URLs for JSF 2.0 web applications. 

You will need to:
- add JSF 2.0 library files (JSF 2.0 Mojarra 2.0.3-FCS was used here).
- add SLF4J libraries

Features:(Refer URLs mentioned in com.jsfurlfilter.context.DefaultUrlContext)<br/>
<ol>
<li>It allows mapping of simple URLs like '/home' to lengthy JSF URLs like '/mylanding/myhome.xhtml'.</li>
<li>Allows redirection of URLs, with choice to preserve request parameters during redirection.</li>
<li>Allows execution of JSF 2.0 EL expression for certain URLs, before start of JSF lifecycle.</li>
<li>Allows to add key-value pairs of request attributes for URLs. This prevents passing of request parameters in query string, thereby having cleaner URLs.</li>
<li>Very simple to understand, looking at source code and javadoc.</li>
</ol>
