<#import "parts/common.ftl" as c>

<@c.page>
    <link rel="stylesheet" href="/static/styles/video.css">

    <div>
        <video width="800" controls>
            <source src="/static/videos/${video.filename}">
        </video>
    </div>
    <div class="parent">
        <div class="inline">
            <div class="video_name">${video.name}</div>
            <div class="video_theme">Theme: ${video.theme}</div>
        </div>
        <div class="inline_big_margin_left">
            <div class="inline_margin estimate_form">
                <form action="/videos/${video.filename}" method="post">
                    <input type="hidden" name="estimate" value="like">
                    <button type="submit" class="btn btn-light">
                        <img src="/static/images/thumbs-up.svg" alt="like">${video.likes}
                    </button>
                </form>
            </div>
            <div class="inline_margin estimate_form">
                <form action="/videos/${video.filename}" method="post">
                    <input type="hidden" name="estimate" value="dislike">
                    <button type="submit" class="btn btn-light">
                        <img src="/static/images/thumbs-down.svg" alt="dislike">${video.dislikes}
                    </button>
                </form>
            </div>
        </div>

        <hr>

        <a href="/users/${user.username}">
            <img src="/static/images/database.svg" width="48">
            <h4 class="inline">${user.username}</h4>
        </a>
    </div>
</@c.page>