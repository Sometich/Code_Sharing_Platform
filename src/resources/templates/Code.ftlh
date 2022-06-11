<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Code</title>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
    <link href="/style.css" rel="stylesheet">
</head>
<body>
<#if code.time gt 0>
<span id="time_restriction">The code will be able for ${code.time} seconds</span><br>
</#if>
<#if code.viewsLimited>
    <span id="views_restriction">${code.views} more views allowed</span><br>
</#if>
<span id="load_date">${code.date}</span>
<pre id="code_snippet"><code>${code.code}</code></pre>
<script src="../static/script.js"></script>
</body>
</html>