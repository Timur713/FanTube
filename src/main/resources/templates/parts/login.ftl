<#macro login path isRegistrForm>

    <#if isRegistrForm>
        <h3>Registration form</h3>
        <p/>
    <#else>
        <h3>Login form</h3>
        <p/>
    </#if>
    <form action="${path}" method="post">

        <div class="form-group row">
            <label class="col-sm-1 col-form-label">Username: </label>
            <div class="col-sm-6">
                <input type="text" name="username" class="form-control" placeholder="Username"/>
            </div>
        </div>

        <#if isRegistrForm>
            <div class="form-group row">
                <label class="col-sm-1 col-form-label">Email: </label>
                <div class="col-sm-6">
                    <input type="text" name="email" class="form-control" placeholder="some@some.com"/>
                </div>
            </div>
        </#if>

        <div class="form-group row">
            <label class="col-sm-1 col-form-label">Password: </label>
            <div class="col-sm-6">
                <input type="password" name="password" class="form-control" placeholder="pass123"/>
            </div>
        </div>

        <#if !isRegistrForm>
            <a href="/registration">Sign up here&nbsp;</a>
         <#else>
             <a href="/login">Log in here&nbsp;&nbsp;&nbsp;</a>
        </#if>
        <button type="submit" class="btn btn-primary"><#if isRegistrForm>Sign up<#else>Sign in</#if></button>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <button type="submit" class="btn btn-light"><img src="/static/images/log-out.svg" class="mr-4" alt="abc"/> Sign
            out
        </button>
    </form>
</#macro>