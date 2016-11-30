<#include "/_layout/base.ftl">

<#macro pageContents>
<header class="header-wrapper row">
    <h1>게시판 상세</h1>
</header>

<div class="article-wrapper row">
    <div class="article-info-wrapper">
        <dl class="dl-horizontal">
            <dt>제목</dt>
            <dd>${article.title}</dd>
        </dl>
        <dl class="dl-horizontal">
            <dt>지은이</dt>
            <dd>${article.author}</dd>
        </dl>
        <dl class="dl-horizontal">
            <dt>시간</dt>
            <dd>${article.created}</dd>
        </dl>
    </div>
    <div class="article-content">
    ${article.content}
    </div>
</div>
</#macro>

<#macro pageScript>
<script>
    console.log("Hello, World!");
</script>
</#macro>


<@pageLayout/>