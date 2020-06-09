<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <link rel="stylesheet" href="/static/styles/navbar.css">

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    <img src="/static/images/menu.svg" class="mr-4"/>
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/">
                        <img src="/static/images/home.svg" class="mr-4"/>Home
                    </a>
                    <a class="dropdown-item" href="#">
                        <img src="/static/images/star.svg" class="mr-4"/>Trending
                    </a>
                    <a class="dropdown-item" href="#">
                        <img src="/static/images/youtube(1).svg" class="mr-4"/>Subscriptions
                    </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/library">
                        <img src="/static/images/folder.svg" class="mr-4"/>Library
                    </a>
                    <a class="dropdown-item" href="#">
                        <img src="/static/images/server.svg" class="mr-4"/> History
                    </a>
                    <a class="dropdown-item" href="#">
                        <img src="/static/images/clock.svg" class="mr-4"/>Watch later
                    </a>
                    <a class="dropdown-item" href="/likedVideos">
                        <img src="/static/images/thumbs-up.svg" class="mr-4"/> Liked videos
                    </a>
                </div>
            </li>
            <li class="navbar-brand">
                <div class="ml-5"><img src="/static/images/youtube.svg" class="mr-2"> <bold>Tube</bold></div>
            </li>
        </ul>

        <div class="btn-group dropleft mr-3">
            <button type="button" class="btn btn-info" id="author_btn" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="false">
                ${name}
            </button>
            <div class="dropdown-menu">
                <#if known>
                    <a class="dropdown-item" href="/profile"><img src="/static/images/user.svg" class="mr-4"> Profile</a>
                    <a class="dropdown-item" href="/logout"><img src="/static/images/log-out.svg" class="mr-4"> Log out</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#"><img src="/static/images/settings.svg" class="mr-4"> Settings</a>
                    <a class="dropdown-item" href="#"><img src="/static/images/help-circle.svg" class="mr-4"> Help</a>

                <#else>
                    <a class="dropdown-item" href="/login"><img src="/static/images/log-out.svg" class="mr-4"> Log in</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#"><img src="/static/images/help-circle.svg" class="mr-4"> Help</a>
                </#if>

            </div>
        </div>
    </div>
</nav>