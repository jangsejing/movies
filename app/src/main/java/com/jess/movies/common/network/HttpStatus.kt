package com.jess.movies.common.network

enum class HttpStatus private constructor(val code: Int, val description: String) {

    /**
     *
     *
     *
     * The client SHOULD continue with its request. This interim response is
     * used to inform the client that the initial part of the request has
     * been received and has not yet been rejected by the server. The client
     * SHOULD continue by sending the remainder of the request or, if the
     * request has already been completed, ignore this response. The server
     * MUST send a final response after the request has been completed. See
     * section
     * [8.2.3](http://www.w3.org/Protocols/rfc2616/rfc2616-sec8.html#sec8.2.3)
     * for detailed discussion of the use and
     * handling of this
     * status code.
     *
     *
     */
    CONTINUE(100, "Continue"),
    /**
     *
     *
     * The server understands and is willing to comply with the client's
     * request, via the Upgrade message header field (section 14.42), for a
     * change in the application protocol being used on this connection. The
     * server will switch protocols to those defined by the response's
     * Upgrade header field immediately after the empty line which
     * terminates the 101 response.
     *
     *
     *
     * The protocol SHOULD be switched only when it is advantageous to do
     * so. For example, switching to a newer version of HTTP is advantageous
     * over older versions, and switching to a real-time, synchronous
     * protocol might be advantageous when delivering resources that use
     * such features.
     *
     */
    SWITCHING_PROTOCOLS(101, "Switching Protocols"),

    /**
     *
     *
     * The request has succeeded. The information returned with the response
     * is dependent on the method used in the request, for example:
     *
     *
     *
     * GET an entity corresponding to the requested resource is sent in
     * the response;
     *
     *
     *
     * HEAD the entity-header fields corresponding to the requested
     * resource are sent in the response without any message-body;
     *
     *
     *
     * POST an entity describing or containing the result of the action;
     *
     *
     *
     * TRACE an entity containing the request message as received by the
     * end server.
     *
     */
    OK(200, "OK"),
    /**
     *
     *
     * The request has been fulfilled and resulted in a new resource being
     * created. The newly created resource can be referenced by the URI(s)
     * returned in the entity of the response, with the most specific URI
     * for the resource given by a Location header field. The response
     * SHOULD include an entity containing a list of resource
     * characteristics and location(s) from which the user or user agent can
     * choose the one most appropriate. The entity format is specified by
     * the media type given in the Content-Type header field. The origin
     * server MUST create the resource before returning the 201 status code.
     * If the action cannot be carried out immediately, the server SHOULD
     * respond with 202 (Accepted) response instead.
     *
     *
     *
     * A 201 response MAY contain an ETag response header field indicating
     * the current value of the entity tag for the requested variant just
     * created, see section
     * [14.19](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.19)
     * .
     *
     *
     */
    CREATED(201, "Created"),
    /**
     *
     *
     * The request has been accepted for processing, but the processing has
     * not been completed. The request might or might not eventually be
     * acted upon, as it might be disallowed when processing actually takes
     * place. There is no facility for re-sending a status code from an
     * asynchronous operation such as this.
     *
     *
     *
     * The 202 response is intentionally non-committal. Its purpose is to
     * allow a server to accept a request for some other process (perhaps a
     * batch-oriented process that is only run once per day) without
     * requiring that the user agent's connection to the server persist
     * until the process is completed. The entity returned with this
     * response SHOULD include an indication of the request's current status
     * and either a pointer to a status monitor or some estimate of when the
     * user can expect the request to be fulfilled.
     *
     */
    ACCEPTED(202, "Accepted"),
    /**
     *
     *
     * The returned metainformation in the entity-header is not the
     * definitive set as available from the origin server, but is gathered
     * from a local or a third-party copy. The set presented MAY be a subset
     * or superset of the original version. For example, including local
     * annotation information about the resource might result in a superset
     * of the metainformation known by the origin server. Use of this
     * response code is not required and is only appropriate when the
     * response would otherwise be 200 (OK).
     *
     */
    NON_AUTHORITATIVE_INFORMATION(203, "Non-Authoritative Information"),
    /**
     *
     *
     * The server has fulfilled the request but does not need to return an
     * entity-body, and might want to return updated metainformation. The
     * response MAY include new or updated metainformation in the form of
     * entity-headers, which if present SHOULD be associated with the
     * requested variant.
     *
     *
     *
     * If the client is a user agent, it SHOULD NOT change its document view
     * from that which caused the request to be sent. This response is
     * primarily intended to allow input for actions to take place without
     * causing a change to the user agent's active document view, although
     * any new or updated metainformation SHOULD be applied to the document
     * currently in the user agent's active view.
     *
     *
     *
     * The 204 response MUST NOT include a message-body, and thus is always
     * terminated by the first empty line after the header fields.
     *
     */
    NO_CONTENT(204, "No Content"),
    /**
     *
     *
     * The server has fulfilled the request and the user agent SHOULD reset
     * the document view which caused the request to be sent. This response
     * is primarily intended to allow input for actions to take place via
     * user input, followed by a clearing of the form in which the input is
     * given so that the user can easily initiate another input action. The
     * response MUST NOT include an entity.
     *
     */
    RESET_CONTENT(205, "Reset Content"),
    /**
     *
     *
     *
     * The server has fulfilled the partial GET request for the resource.
     * The request MUST have included a Range header field (section 14.35)
     * indicating the desired range, and MAY have included an If-Range
     * header field (section
     * [14.27](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.27)
     * ) to make the request
     * conditional.
     *
     *
     *
     *
     * The response MUST include the following header fields:
     *
     * <pre>      - Either a Content-Range header field (section 14.16) indicating
     * the range included with this response, or a multipart/byteranges
     * Content-Type including Content-Range fields for each part. If a
     * Content-Length header field is present in the response, its
     * value MUST match the actual number of OCTETs transmitted in the
     * message-body.
    </pre> *
     * <pre>      - Date
    </pre> *
     * <pre>      - ETag and/or Content-Location, if the header would have been sent
     * in a 200 response to the same request
    </pre> *
     * <pre>      - Expires, Cache-Control, and/or Vary, if the field-value might
     * differ from that sent in any previous response for the same
     * variant
    </pre> *
     *
     *
     * If the 206 response is the result of an If-Range request that used a
     * strong cache validator (see section 13.3.3), the response SHOULD NOT
     * include other entity-headers. If the response is the result of an
     * If-Range request that used a weak validator, the response MUST NOT
     * include other entity-headers; this prevents inconsistencies between
     * cached entity-bodies and updated headers. Otherwise, the response
     * MUST include all of the entity-headers that would have been returned
     * with a 200 (OK) response to the same request.
     *
     *
     *
     *
     * A cache MUST NOT combine a 206 response with other previously cached
     * content if the ETag or Last-Modified headers do not match exactly,
     * see
     * [13.5.4](http://www.w3.org/Protocols/rfc2616/rfc2616-sec13.html#sec13.5.4)
     * .
     *
     *
     *
     *
     * A cache that does not support the Range and Content-Range headers
     * MUST NOT cache 206 (Partial) responses.
     *
     */
    PARTIAL_CONTENT(206, "Partial Content"),

    /**
     *
     *
     * The requested resource corresponds to any one of a set of
     * representations, each with its own specific location, and agent-
     * driven negotiation information (section 12) is being provided so that
     * the user (or user agent) can select a preferred representation and
     * redirect its request to that location.
     *
     *
     *
     * Unless it was a HEAD request, the response SHOULD include an entity
     * containing a list of resource characteristics and location(s) from
     * which the user or user agent can choose the one most appropriate. The
     * entity format is specified by the media type given in the Content-
     * Type header field. Depending upon the format and the capabilities of
     *
     *
     *
     * the user agent, selection of the most appropriate choice MAY be
     * performed automatically. However, this specification does not define
     * any standard for such automatic selection.
     *
     *
     *
     * If the server has a preferred choice of representation, it SHOULD
     * include the specific URI for that representation in the Location
     * field; user agents MAY use the Location field value for automatic
     * redirection. This response is cacheable unless indicated otherwise.
     *
     */
    MULTIPLE_CHOICES(300, "Multiple Choices"),
    /**
     *
     *
     * The requested resource has been assigned a new permanent URI and any
     * future references to this resource SHOULD use one of the returned
     * URIs. Clients with link editing capabilities ought to automatically
     * re-link references to the Request-URI to one or more of the new
     * references returned by the server, where possible. This response is
     * cacheable unless indicated otherwise.
     *
     *
     *
     * The new permanent URI SHOULD be given by the Location field in the
     * response. Unless the request method was HEAD, the entity of the
     * response SHOULD contain a short hypertext note with a hyperlink to
     * the new URI(s).
     *
     *
     *
     * If the 301 status code is received in response to a request other
     * than GET or HEAD, the user agent MUST NOT automatically redirect the
     * request unless it can be confirmed by the user, since this might
     * change the conditions under which the request was issued.
     *
     * <pre>      Note: When automatically redirecting a POST request after
     * receiving a 301 status code, some existing HTTP/1.0 user agents
     * will erroneously change it into a GET request.
    </pre> *
     */
    MOVED_PERMANENTLY(301, "Moved Permanently"),
    /**
     *
     *
     * The requested resource resides temporarily under a different URI.
     * Since the redirection might be altered on occasion, the client SHOULD
     * continue to use the Request-URI for future requests. This response
     * is only cacheable if indicated by a Cache-Control or Expires header
     * field.
     *
     *
     *
     * The temporary URI SHOULD be given by the Location field in the
     * response. Unless the request method was HEAD, the entity of the
     * response SHOULD contain a short hypertext note with a hyperlink to
     * the new URI(s).
     *
     *
     *
     * If the 302 status code is received in response to a request other
     * than GET or HEAD, the user agent MUST NOT automatically redirect the
     * request unless it can be confirmed by the user, since this might
     * change the conditions under which the request was issued.
     *
     * <pre>      Note: RFC 1945 and RFC 2068 specify that the client is not allowed
     * to change the method on the redirected request.  However, most
     * existing user agent implementations treat 302 as if it were a 303
     * response, performing a GET on the Location field-value regardless
     * of the original request method. The status codes 303 and 307 have
     * been added for servers that wish to make unambiguously clear which
     * kind of reaction is expected of the client.
    </pre> *
     */
    FOUND(302, "Found"),
    /**
     *
     *
     * The response to the request can be found under a different URI and
     * SHOULD be retrieved using a GET method on that resource. This method
     * exists primarily to allow the output of a POST-activated script to
     * redirect the user agent to a selected resource. The new URI is not a
     * substitute reference for the originally requested resource. The 303
     * response MUST NOT be cached, but the response to the second
     * (redirected) request might be cacheable.
     *
     *
     *
     * The different URI SHOULD be given by the Location field in the
     * response. Unless the request method was HEAD, the entity of the
     * response SHOULD contain a short hypertext note with a hyperlink to
     * the new URI(s).
     *
     * <pre>      Note: Many pre-HTTP/1.1 user agents do not understand the 303
     * status. When interoperability with such clients is a concern, the
     * 302 status code may be used instead, since most user agents react
     * to a 302 response as described here for 303.
    </pre> *
     */
    SEE_OTHER(303, "See Other"),
    /**
     *
     *
     * If the client has performed a conditional GET request and access is
     * allowed, but the document has not been modified, the server SHOULD
     * respond with this status code. The 304 response MUST NOT contain a
     * message-body, and thus is always terminated by the first empty line
     * after the header fields.
     *
     *
     *
     * The response MUST include the following header fields:
     *
     * <pre>      - Date, unless its omission is required by section 14.18.1
    </pre> *
     *
     *
     *
     * If a clockless origin server obeys these rules, and proxies and
     * clients add their own Date to any response received without one (as
     * already specified by [RFC 2068], section
     * [14.19](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.19)
     * ), caches
     * will operate
     * correctly.
     *
     *
     * <pre>      - ETag and/or Content-Location, if the header would have been sent
     * in a 200 response to the same request
    </pre> *
     * <pre>      - Expires, Cache-Control, and/or Vary, if the field-value might
     * differ from that sent in any previous response for the same
     * variant
    </pre> *
     *
     *
     * If the conditional GET used a strong cache validator (see section
     * 13.3.3), the response SHOULD NOT include other entity-headers.
     * Otherwise (i.e., the conditional GET used a weak validator), the
     * response MUST NOT include other entity-headers; this prevents
     * inconsistencies between cached entity-bodies and updated headers.
     *
     *
     *
     * If a 304 response indicates an entity not currently cached, then the
     * cache MUST disregard the response and repeat the request without the
     * conditional.
     *
     *
     *
     * If a cache uses a received 304 response to update a cache entry, the
     * cache MUST update the entry to reflect any new field values given in
     * the response.
     *
     */
    NOT_MODIFIED(304, "Not Modified"),
    /**
     *
     *
     * The requested resource MUST be accessed through the proxy given by
     * the Location field. The Location field gives the URI of the proxy.
     * The recipient is expected to repeat this single request via the
     * proxy. 305 responses MUST only be generated by origin servers.
     *
     * <pre>      Note: RFC 2068 was not clear that 305 was intended to redirect a
     * single request, and to be generated by origin servers only.  Not
     * observing these limitations has significant security consequences.
    </pre> *
     */
    USE_PROXY(305, "Use Proxy"),
    /**
     *
     *
     * The requested resource resides temporarily under a different URI.
     * Since the redirection MAY be altered on occasion, the client SHOULD
     * continue to use the Request-URI for future requests. This response
     * is only cacheable if indicated by a Cache-Control or Expires header
     * field.
     *
     *
     *
     * The temporary URI SHOULD be given by the Location field in the
     * response. Unless the request method was HEAD, the entity of the
     * response SHOULD contain a short hypertext note with a hyperlink to
     * the new URI(s) , since many pre-HTTP/1.1 user agents do not
     * understand the 307 status. Therefore, the note SHOULD contain the
     * information necessary for a user to repeat the original request on
     * the new URI.
     *
     *
     *
     * If the 307 status code is received in response to a request other
     * than GET or HEAD, the user agent MUST NOT automatically redirect the
     * request unless it can be confirmed by the user, since this might
     * change the conditions under which the request was issued.
     *
     */
    TEMPORARY_REDIRECT(307, "Temporary Redirect"),

    /**
     *
     *
     * The request could not be understood by the server due to malformed
     * syntax. The client SHOULD NOT repeat the request without
     * modifications.
     *
     */
    BAD_REQUEST(400, "Bad Request"),
    /**
     *
     *
     *
     * The request requires user authentication. The response MUST include a
     * WWW-Authenticate header field (section 14.47) containing a challenge
     * applicable to the requested resource. The client MAY repeat the
     * request with a suitable Authorization header field (section
     * [14.8](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.8)
     * ). If
     * the request already included Authorization credentials, then the 401
     * response indicates that authorization has been refused for those
     * credentials. If the 401 response contains the same challenge as the
     * prior response, and the user agent has already attempted
     * authentication at least once, then the user SHOULD be presented the
     * entity that was given in the response, since that entity might
     * include relevant diagnostic information. HTTP access authentication
     * is explained in &quot;HTTP Authentication: Basic and Digest Access
     * Authentication&quot;
     * [[43]](http://www.w3.org/Protocols/rfc2616/rfc2616-sec17.html#bib43)
     * .
     *
     *
     */
    UNAUTHORIZED(401, "Unauthorized"),
    /**
     *
     *
     * This code is reserved for future use.
     *
     */
    PAYMENT_REQUIRED(402, "Payment Required"),
    /**
     *
     *
     * The server understood the request, but is refusing to fulfill it.
     * Authorization will not help and the request SHOULD NOT be repeated.
     * If the request method was not HEAD and the server wishes to make
     * public why the request has not been fulfilled, it SHOULD describe the
     * reason for the refusal in the entity. If the server does not wish to
     * make this information available to the client, the status code 404
     * (Not Found) can be used instead.
     *
     */
    FORBIDDEN(403, "Forbidden"),
    /**
     *
     *
     * The server has not found anything matching the Request-URI. No
     * indication is given of whether the condition is temporary or
     * permanent. The 410 (Gone) status code SHOULD be used if the server
     * knows, through some internally configurable mechanism, that an old
     * resource is permanently unavailable and has no forwarding address.
     * This status code is commonly used when the server does not wish to
     * reveal exactly why the request has been refused, or when no other
     * response is applicable.
     *
     */
    NOT_FOUND(404, "Not Found"),
    /**
     *
     *
     * The method specified in the Request-Line is not allowed for the
     * resource identified by the Request-URI. The response MUST include an
     * Allow header containing a list of valid methods for the requested
     * resource.
     *
     */
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    /**
     *
     *
     * The resource identified by the request is only capable of generating
     * response entities which have content characteristics not acceptable
     * according to the accept headers sent in the request.
     *
     *
     *
     * Unless it was a HEAD request, the response SHOULD include an entity
     * containing a list of available entity characteristics and location(s)
     * from which the user or user agent can choose the one most
     * appropriate. The entity format is specified by the media type given
     * in the Content-Type header field. Depending upon the format and the
     * capabilities of the user agent, selection of the most appropriate
     * choice MAY be performed automatically. However, this specification
     * does not define any standard for such automatic selection.
     *
     * <pre>      Note: HTTP/1.1 servers are allowed to return responses which are
     * not acceptable according to the accept headers sent in the
     * request. In some cases, this may even be preferable to sending a
     * 406 response. User agents are encouraged to inspect the headers of
     * an incoming response to determine if it is acceptable.
    </pre> *
     *
     *
     * If the response could be unacceptable, a user agent SHOULD
     * temporarily stop receipt of more data and query the user for a
     * decision on further actions.
     *
     */
    NOT_ACCEPTABLE(406, "Not Acceptable"),
    /**
     *
     *
     *
     * This code is similar to 401 (Unauthorized), but indicates that the
     * client must first authenticate itself with the proxy. The proxy MUST
     * return a Proxy-Authenticate header field (section
     * [14.33](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.33)
     * )
     * containing a
     * challenge applicable to the proxy for the requested resource. The
     * client MAY repeat the request with a suitable Proxy-Authorization
     * header field (section
     * [14.34](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.34)
     * ). HTTP access authentication is
     * explained
     * in &quot;HTTP Authentication: Basic and Digest Access Authentication&quot;
     *
     * [[43]](http://www.w3.org/Protocols/rfc2616/rfc2616-sec17.html#bib43)
     * .
     *
     *
     */
    PROXY_AUTHENTICATION_REQUIRED(407, "Proxy Authentication Required"),
    /**
     *
     *
     * The client did not produce a request within the time that the server
     * was prepared to wait. The client MAY repeat the request without
     * modifications at any later time.
     *
     */
    REQUEST_TIMEOUT(408, "Request Timeout"),
    /**
     *
     *
     * The request could not be completed due to a conflict with the current
     * state of the resource. This code is only allowed in situations where
     * it is expected that the user might be able to resolve the conflict
     * and resubmit the request. The response body SHOULD include enough
     *
     *
     *
     * information for the user to recognize the source of the conflict.
     * Ideally, the response entity would include enough information for the
     * user or user agent to fix the problem; however, that might not be
     * possible and is not required.
     *
     *
     *
     * Conflicts are most likely to occur in response to a PUT request. For
     * example, if versioning were being used and the entity being PUT
     * included changes to a resource which conflict with those made by an
     * earlier (third-party) request, the server might use the 409 response
     * to indicate that it can't complete the request. In this case, the
     * response entity would likely contain a list of the differences
     * between the two versions in a format defined by the response
     * Content-Type.
     *
     */
    CONFLICT(409, "Conflict"),
    /**
     *
     *
     * The requested resource is no longer available at the server and no
     * forwarding address is known. This condition is expected to be
     * considered permanent. Clients with link editing capabilities SHOULD
     * delete references to the Request-URI after user approval. If the
     * server does not know, or has no facility to determine, whether or not
     * the condition is permanent, the status code 404 (Not Found) SHOULD be
     * used instead. This response is cacheable unless indicated otherwise.
     *
     *
     *
     * The 410 response is primarily intended to assist the task of web
     * maintenance by notifying the recipient that the resource is
     * intentionally unavailable and that the server owners desire that
     * remote links to that resource be removed. Such an event is common for
     * limited-time, promotional services and for resources belonging to
     * individuals no longer working at the server's site. It is not
     * necessary to mark all permanently unavailable resources as &quot;gone&quot; or
     * to keep the mark for any length of time -- that is left to the
     * discretion of the server owner.
     *
     */
    GONE(410, "Gone"),
    /**
     *
     *
     * The server refuses to accept the request without a defined Content-
     * Length. The client MAY repeat the request if it adds a valid
     * Content-Length header field containing the length of the message-body
     * in the request message.
     *
     */
    LENGTH_REQUIRED(411, "Length Required"),
    /**
     *
     *
     * The precondition given in one or more of the request-header fields
     * evaluated to false when it was tested on the server. This response
     * code allows the client to place preconditions on the current resource
     * metainformation (header field data) and thus prevent the requested
     * method from being applied to a resource other than the one intended.
     *
     */
    PRECONDITION_FAILED(412, "Precondition Failed"),
    /**
     *
     *
     * The server is refusing to process a request because the request
     * entity is larger than the server is willing or able to process. The
     * server MAY close the connection to prevent the client from continuing
     * the request.
     *
     *
     *
     * If the condition is temporary, the server SHOULD include a Retry-
     * After header field to indicate that it is temporary and after what
     * time the client MAY try again.
     *
     */
    REQUEST_ENTITY_TOO_LARGE(413, "Request Entity Too Large"),
    /**
     *
     *
     * The server is refusing to service the request because the Request-URI
     * is longer than the server is willing to interpret. This rare
     * condition is only likely to occur when a client has improperly
     * converted a POST request to a GET request with long query
     * information, when the client has descended into a URI &quot;black hole&quot; of
     * redirection (e.g., a redirected URI prefix that points to a suffix of
     * itself), or when the server is under attack by a client attempting to
     * exploit security holes present in some servers using fixed-length
     * buffers for reading or manipulating the Request-URI.
     *
     */
    REQUEST_URI_TOO_LONG(414, "Request-URI Too Long"),
    /**
     *
     *
     * The server is refusing to service the request because the entity of
     * the request is in a format not supported by the requested resource
     * for the requested method.
     *
     */
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
    /**
     *
     *
     * A server SHOULD return a response with this status code if a request
     * included a Range request-header field (section 14.35), and none of
     * the range-specifier values in this field overlap the current extent
     * of the selected resource, and the request did not include an If-Range
     * request-header field. (For byte-ranges, this means that the first-
     * byte-pos of all of the byte-range-spec values were greater than the
     * current length of the selected resource.)
     *
     *
     *
     *
     * When this status code is returned for a byte-range request, the
     * response SHOULD include a Content-Range entity-header field
     * specifying the current length of the selected resource (see section
     *
     * [14.16](http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.16)
     * ). This response MUST NOT use the multipart/byteranges
     * content-
     * type.
     *
     *
     */
    REQUESTED_RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable"),
    /**
     *
     *
     * The expectation given in an Expect request-header field (see section
     * 14.20) could not be met by this server, or, if the server is a proxy,
     * the server has unambiguous evidence that the request could not be met
     * by the next-hop server.
     *
     */
    EXPECTATION_FAILED(417, "Expectation Failed"),
    /**
     *
     *
     * The 428 status code indicates that the origin server requires the
     * request to be conditional.
     *
     *
     *
     * Its typical use is to avoid the &quot;lost update&quot; problem, where a client
     * GETs a resource's state, modifies it, and PUTs it back to the server,
     * when meanwhile a third party has modified the state on the server,
     * leading to a conflict.  By requiring requests to be conditional, the
     * server can assure that clients are working with the correct copies.
     *
     *
     *
     * Responses using this status code SHOULD explain how to resubmit the
     * request successfully.
     *
     */
    PRECONDITION_REQUIRED(428, "Precondition Required"),
    /**
     *
     *
     * The 429 status code indicates that the user has sent too many
     * requests in a given amount of time (&quot;rate limiting&quot;).
     *
     *
     *
     * The response representations SHOULD include details explaining the
     * condition, and MAY include a Retry-After header indicating how long
     * to wait before making a new request.
     *
     *
     *
     * Note that this specification does not define how the origin server
     * identifies the user, nor how it counts requests.  For example, an
     * origin server that is limiting request rates can do so based upon
     * counts of requests on a per-resource basis, across the entire server,
     * or even among a set of servers.  Likewise, it might identify the user
     * by its authentication credentials, or a stateful cookie.
     *
     *
     *
     * Responses with the 429 status code MUST NOT be stored by a cache.
     *
     */
    TOO_MANY_REQUESTS(429, "Too Many Requests"),
    /**
     *
     *
     * The 431 status code indicates that the server is unwilling to process
     * the request because its header fields are too large.  The request MAY
     * be resubmitted after reducing the size of the request header fields.
     *
     *
     *
     * It can be used both when the set of request header fields in total is
     * too large, and when a single header field is at fault.  In the latter
     * case, the response representation SHOULD specify which header field
     * was too large.
     *
     *
     *
     * Responses with the 431 status code MUST NOT be stored by a cache.
     *
     */
    REQUEST_HEADER_FIELDS_TOO_LARGE(431, "Request Header Fields Too Large"),
    /**
     *
     *
     * This status code indicates that the server is denying access to the
     * resource as a consequence of a legal demand.
     *
     *
     *
     * The server in question may not be an origin server.  This type of
     * legal demand typically most directly affects the operations of ISPs
     * and search engines.
     *
     *
     *
     * Responses using this status code SHOULD include an explanation, in
     * the response body, of the details of the legal demand: the party
     * making it, the applicable legislation or regulation, and what classes
     * of person and resource it applies to.
     *
     *
     *
     * The use of the 451 status code implies neither the existence nor non-
     * existence of the resource named in the request.  That is to say, it
     * is possible that if the legal demands were removed, a request for the
     * resource still might not succeed.
     *
     *
     *
     * Note that in many cases clients can still access the denied resource
     * by using technical countermeasures such as a VPN or the Tor network.
     *
     */
    UNAVAILABLE_FOR_LEGAL_REASONS(451, "Unavailable For Legal Reasons"),

    /**
     *
     *
     * The server encountered an unexpected condition which prevented it
     * from fulfilling the request.
     *
     */
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    /**
     *
     *
     * The server does not support the functionality required to fulfill the
     * request. This is the appropriate response when the server does not
     * recognize the request method and is not capable of supporting it for
     * any resource.
     *
     */
    NOT_IMPLEMENTED(501, "Not Implemented"),
    /**
     *
     *
     * The server, while acting as a gateway or proxy, received an invalid
     * response from the upstream server it accessed in attempting to
     * fulfill the request.
     *
     */
    BAD_GATEWAY(502, "Bad Gateway"),
    /**
     *
     *
     * The server is currently unable to handle the request due to a
     * temporary overloading or maintenance of the server. The implication
     * is that this is a temporary condition which will be alleviated after
     * some delay. If known, the length of the delay MAY be indicated in a
     * Retry-After header. If no Retry-After is given, the client SHOULD
     * handle the response as it would for a 500 response.
     *
     * <pre>      Note: The existence of the 503 status code does not imply that a
     * server must use it when becoming overloaded. Some servers may wish
     * to simply refuse the connection.
    </pre> *
     */
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),
    /**
     *
     *
     * The server, while acting as a gateway or proxy, did not receive a
     * timely response from the upstream server specified by the URI (e.g.
     * HTTP, FTP, LDAP) or some other auxiliary server (e.g. DNS) it needed
     * to access in attempting to complete the request.
     *
     * <pre>      Note: Note to implementors: some deployed proxies are known to
     * return 400 or 500 when DNS lookups time out.
    </pre> *
     */
    GATEWAY_TIMEOUT(504, "Gateway Timeout"),
    /**
     *
     *
     *
     * The server does not support, or refuses to support, the HTTP protocol
     * version that was used in the request message. The server is
     * indicating that it is unable or unwilling to complete the request
     * using the same major version as the client, as described in section
     *
     * [3.1](http://www.w3.org/Protocols/rfc2616/rfc2616-sec3.html#sec3.1)
     * , other than with this error message. The response SHOULD
     * contain
     * an entity describing why that version is not supported and what other
     * protocols are supported by that server.
     *
     *
     */
    HTTP_VERSION_NOT_SUPPORTED(505, "HTTP Version Not Supported"),
    /**
     *
     *
     * The 511 status code indicates that the client needs to authenticate
     * to gain network access.
     *
     *
     *
     * The response representation SHOULD contain a link to a resource that
     * allows the user to submit credentials (e.g., with an HTML form).
     *
     *
     *
     * Note that the 511 response SHOULD NOT contain a challenge or the
     * login interface itself, because browsers would show the login
     * interface as being associated with the originally requested URL,
     * which may cause confusion.
     *
     *
     *
     * The 511 status SHOULD NOT be generated by origin servers; it is
     * intended for use by intercepting proxies that are interposed as a
     * means of controlling access to the network.
     *
     *
     *
     * Responses with the 511 status code MUST NOT be stored by a cache.
     *
     */
    NETWORK_AUTHENTICATION_REQUIRED(511, "Network Authentication Required");

    override fun toString(): String {
        return "$code $description"
    }

    companion object {

        fun valueOf(code: Int): HttpStatus? {
            for (httpStatus in values()) {
                if (httpStatus.code == code) {
                    return httpStatus
                }
            }
            return null
        }
    }
}