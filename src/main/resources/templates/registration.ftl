<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <#if userExists??>
        <div class="alert alert-danger col-md-7" role="alert">
            ${userExists!}
        </div>
    </#if>
    <@l.login "/registration" true/>
</@c.page>