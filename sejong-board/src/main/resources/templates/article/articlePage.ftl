<#include "/_layout/base.ftl">

<#macro pageContents>
<header class="header-wrapper row">
    <h1>게시판 샘플</h1>
</header>

<div class="row">
    <article class="table-wrapper row">
        <table class="table table-hover">
            <thead>
            <tr>
                <th class="col-sm-1">#</th>
                <th class="col-sm-6">제목</th>
                <th class="col-sm-2">작성자</th>
                <th class="col-sm-3">시간</th>
            </tr>
            </thead>
            <tbody>
                <#list articlePage.content as article>
                <tr class="article-row" data-articleId="${article.id?c}">
                    <td>${article.id?c}</td>
                    <td>${article.title}</td>
                    <td>${article.author}</td>
                    <td>${article.created}</td>
                </tr>
                </#list>
            </tbody>
        </table>
    </article>
    <div class="row button">
        <span class="pull-right">
            <a href="/articles/write" class="btn btn-default btn-lg">글쓰기</a>
        </span>
    </div>

    <div class="row">
        <nav aria-label="page-nav">
            <ul class="pager">
                <#if articlePage.number gt 0>
                    <li class="previous">
                        <a href="/articles?page=${articlePage.number - 1}"><span aria-hidden="true">&larr;</span> Prev</a>
                    </li>
                <#else>
                    <li class="previous disabled">
                        <a href="#"><span aria-hidden="true">&larr;</span> Older</a>
                    </li>
                </#if>

                <#if articlePage.number lt (articlePage.totalPages - 1)>
                    <li class="next">
                        <a href="/articles?page=${articlePage.number + 1}">Next <span aria-hidden="true">&rarr;</span></a>
                    </li>
                <#else>
                    <li class="next disabled">
                        <a href="#">Newer <span aria-hidden="true">&rarr;</span></a>
                    </li>
                </#if>
            </ul>
        </nav>
    </div>

</div>
</#macro>

<#macro pageScript>
<script>
    $(".article-row").on("click", function () {
        var articleId = $(this).attr("data-articleId");
        location.href = "/articles/" + articleId;
    });
</script>
</#macro>


<@pageLayout/>