<#if k % 10 == 0>
    <#assign x = (k / 10)?round>
<#else>
    <#assign x = (k / 10)?round + 1>
</#if>
<#assign maxPage=x>
<#if count != maxPage>
    <#assign x = count * 10>
<#elseif k % 10 != 0>
    <#assign x=k % 10 + (count - 1) * 10>
<#else>
    <#assign x=k>
</#if>
<#assign maxID=x>