<#import "parts/common.ftl" as c>

<@c.page>
    <link rel="stylesheet" href="/static/styles/library.css">
    <script src="/static/scripts/library.js"></script>

    <div>
        <img src="/static/images/book.svg" alt="" width="48"/>
        <div class="library_name">Library</div>
        <#--        --------------------------------------------------------------->

        <button class="btn btn-success inline" id="create_playlist_btn" onclick="openForm()">
            Create playlist
        </button>
    </div>

    <div id="createPlaylistForm">
        <form action="/library">
            <div class="formHeading">Create playlist</div>
            <button onclick="closeForm()" id="closeForm_btn" class="btn btn-danger">X</button>

            <div class="input-group ml-5 w-75 mt-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1">Playlist name: </span>
                </div>
                <input type="text" class="form-control" placeholder="My playlist">
            </div>
            <div class="chooseVideosHeader">Choose videos:</div>
            <div class="videosBlock">
                <#if videos??>
                    <#list videos as video>
                        <div class="video_mini_block">
                            <video controls width="216" height="120">
                                <source src="/static/videos/${video.filename}" type="video/mp4">
                            </video>
                            ${video.name}
                        </div>
                    </#list>
                    <#else>
                        <div class="alert alert-secondary" role="alert">
                            You don't have any videos.
                        </div>
                </#if>
            </div>
            <div class="inner_create_playlist_btn">
                <button class="btn btn-success">Create</button>
            </div>
        </form>
    </div>

    <hr/>

    <#if playlists??>

    <#else>
        <div class="alert alert-secondary no_playlist" role="alert">
            You don't have any playlists.
        </div>
    </#if>

</@c.page>