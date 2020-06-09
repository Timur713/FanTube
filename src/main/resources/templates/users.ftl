<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
    <link rel="stylesheet" href="/static/styles/videos.css">
    <link rel="stylesheet" href="/static/styles/users.css">

    <img src="/static/images/database.svg" width="48" class="inline author_img"/><h3 class="inline"> ${author_name}</h3>
    <hr/>
    <#if author_videos??>
        <#list author_videos as video>
            <div class="parent">
                <a href="/videos/${video.filename}">
                    <video controls width="315" class="video">
                        <source src="/static/videos/${video.filename}" type="video/mp4">
                    </video>
                </a>
                <div class="details">
                    <a href="/videos/${video.filename}"><h5 class="card-title">${video.name}</h5></a>
                    <a href="/users/${video.authorName}"><p class="card-text">
                            <img src="/static/images/database.svg"/>${video.authorName}</p></a>
                    <p class="card-text"><small class="text-muted">10k Views | 1 years ago</small></p>
                </div>
            </div>
        </#list>
    </#if>
</@c.page>