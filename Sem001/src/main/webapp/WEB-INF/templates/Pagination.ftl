<#if maxPage != 1>
<#assign path=model["path"]>
<center>
    <ul type="" class="pagination">
        <#if count - 1 != 0>
            <#if count - 2 != -1 && count - 2 != 0>
                <#if count - 2 gt 1>
                    <li><a href="${path}?count=1">&laquo;</a></li>
                </#if>
                <li><a href="${path}?count=${count - 2}">${count - 2}
                </a></li>
            </#if>
            <li><a href="${path}?count=${count - 1}">${count - 1}
            </a></li>
        </#if>
        <li><a href="${path}?count=${count}">${count}</a></li>
        <#if maxPage gte count + 1 >
            <li><a href="${path}?count=${count + 1}">${count + 1}
            </a></li>
            <#if maxPage gte count + 2 >
                <li><a href="${path}?count=${count + 2}">${count + 2}
                </a></li>
                <#if maxPage gt count + 2 >
                    <li><a href="${path}?count=${maxPage}">&raquo;</a></li>
                </#if>
            </#if>
        </#if>
    </ul>
</center>
</#if>