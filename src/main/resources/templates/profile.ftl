<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
    <link rel="stylesheet" href="/static/styles/profile.css">
    <link rel="stylesheet" href="/static/styles/videos.css">

    <img src="/static/images/database.svg" width="60" class="inline"/><h3 class="inline"> ${name}</h3>
    <div class="dropdown inline col-md-3">
        <button class="btn btn-info dropdown-toggle col-md-9" type="button" id="dropdownMenuButton"
                data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
            Change data
        </button>
        <div class="dropdown-menu">
            <form action="/profile" method="post" class="px-4 py-3">
                <div class="form-group">
                    <label for="exampleDropdownFormEmail1">Email: </label>
                    <input type="email" class="form-control" id="exampleDropdownFormEmail1" name="email"
                           placeholder="some@some.com">
                </div>
                <div class="form-group">
                    <label for="exampleDropdownFormPassword1">Password: </label>
                    <input type="password" class="form-control" id="exampleDropdownFormPassword1" name="password"
                           placeholder="pass123">
                </div>
                <button type="submit" class="btn btn-success">Change</button>
            </form>
        </div>
    </div>
    <div class="dropdown inline">
        <button class="btn btn-info dropdown-toggle" type="button" id="dropdownMenuButton"
                data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
            Add video
        </button>
        <div class="dropdown-menu">
            <form action="/profile/addVideo" method="post" class="px-4 py-3" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="exampleDropdownFormEmail1">Video name: </label>
                    <input type="text" class="form-control" id="exampleDropdownFormEmail1" name="name"
                           placeholder="Clash Royale tactics">
                </div>
                <div class="form-group">
                    <label for="inputState">Theme: </label>
                    <select id="inputState" class="form-control" name="theme">
                        <option selected>Game</option>
                        <option>Music</option>
                        <option>Film</option>
                    </select>
                </div>
                <div class="form-group">
                    <div class="custom-file">
                        <input type="file" name="file" id="customFile"/>
                        <label class="custom-file-label" for="customFile">Choose file</label>
                    </div>
                </div>
                <button type="submit" class="btn btn-success">Add</button>
            </form>
        </div>
    </div>
    <hr/>
    <#if videoList??>
        <#list videoList as video>
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