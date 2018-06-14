
<%@ page import="urlapi.UrlEntry" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'urlEntry.label', default: 'UrlEntry')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-urlEntry" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-urlEntry" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="longUrl" title="${message(code: 'urlEntry.longUrl.label', default: 'Long Url')}" />
					
						<g:sortableColumn property="shortUrl" title="${message(code: 'urlEntry.shortUrl.label', default: 'Short Url')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${urlEntryInstanceList}" status="i" var="urlEntryInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${urlEntryInstance.id}">${fieldValue(bean: urlEntryInstance, field: "longUrl")}</g:link></td>
					
						<td>${fieldValue(bean: urlEntryInstance, field: "shortUrl")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${urlEntryInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
