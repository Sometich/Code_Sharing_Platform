<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create</title>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
    <link href="/style.css" rel="stylesheet">
</head>
<body>
Длительность доступа к коду
<input id="time_restriction" type="text"/>
<br>
Максимальное количество просмотров
<input id="views_restriction" type="text"/>
<br>
<textarea id="code_snippet" placeholder="// Введите сюда свой код"></textarea>
<button id="send_snippet" type="submit" onclick="send()">Submit</button>
<script src="../static/script.js"></script>
</body>
</html>