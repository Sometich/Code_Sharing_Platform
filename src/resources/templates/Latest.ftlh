<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Latest</title>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
    <link href="/style.css" rel="stylesheet">
</head>
<body>
<#list codes as code>
    <span id="load_date">${code.date}</span>
    <pre id="code_snippet"><code>${code.code}</code></pre>
    <script src="../static/script.js"></script>
</#list>
</body>
</html>