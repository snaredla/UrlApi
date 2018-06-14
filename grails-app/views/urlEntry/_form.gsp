<%@ page import="urlapi.UrlEntry" %>



<div class="fieldcontain ${hasErrors(bean: urlEntryInstance, field: 'longUrl', 'error')} required">
	<label for="longUrl">
		<g:message code="urlEntry.longUrl.label" default="Long Url" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="longUrl" required="" value="${urlEntryInstance?.longUrl}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: urlEntryInstance, field: 'shortUrl', 'error')} required">
	<label for="shortUrl">
		<g:message code="urlEntry.shortUrl.label" default="Short Url" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="shortUrl" required="" value="${urlEntryInstance?.shortUrl}"/>

</div>

