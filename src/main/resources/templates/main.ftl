<#import "parts/common.ftl" as c>
<#import "parts/navbar.ftl" as n>

<@c.page>
    <link rel="stylesheet" href="styles/videos.css">

    <#if allVideos??>
        <#list allVideos as video>
            <a href="/videos/${video.filename}">
                <div class="parent">
                    <a href="/videos/${video.filename}">
                        <video controls width="315" class="video">
                            <source src="/static/videos/${video.filename}" type="video/mp4">
                        </video>
                    </a>
                    <div class="details">
                        <a href="/videos/${video.filename}"><h5 class="card-title">${video.name}</h5></a>
                        <a href="/users/${video.authorName}"><p class="card-text">
                                <img src="/static/images/database.svg"/> ${video.authorName}</p></a>
                        <p class="card-text"><small class="text-muted">10k Views | 1 years ago</small></p>
                    </div>
                </div>
            </a>
        </#list>
    </#if>

</@c.page>