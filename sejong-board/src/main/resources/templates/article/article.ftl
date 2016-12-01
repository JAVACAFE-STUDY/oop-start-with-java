<#include "/_layout/base.ftl">

<#macro pageContents>
<header class="header-wrapper row">
    <div class="col-sm-offset-2 col-sm-10">
        <h1>게시판 상세</h1>
        <hr>
    </div>
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
        <dl class="dl-horizontal">
            <dt>태그</dt>
            <dd>
                <#list article.tags as tag>
                    <span class="label label-default">${tag.name}</span>
                </#list>
            </dd>
        </dl>
    </div>


    <div class="article-contents col-sm-offset-1 col-sm-11">
        <div class="panel panel-default">
            <div class="panel-body">${article.contents}</div>
        </div>
    </div>

    <div class="row button-wrapper">
        <div class="col-sm-offset-1 col-sm-11">
            <span>
                <a href="/articles" class="btn btn-default btn-lg">목록</a>
            </span>
            <span class="pull-right">
                <a href="/articles/${article.id}/modify" class="btn btn-default btn-lg">수정</a>
            </span>
        </div>
    </div>

</div>
</#macro>

<#macro pageScript>
</#macro>

<@pageLayout/>