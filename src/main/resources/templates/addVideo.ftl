<#import "parts/common.ftl" as c>

<@c.page>
    <#if load_success??>
        <div class="alert alert-success" role="alert">
            ${load_success!}
        </div>
        <#else>
        <div class="alert alert-danger" role="alert">
            ${load_wrong!}
        </div>
    </#if>
    <a href="/profile">return to profile</a>

</@c.page>