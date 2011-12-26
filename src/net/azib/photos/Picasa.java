package net.azib.photos;

import com.google.gdata.client.photos.PicasawebService;
import com.google.gdata.data.IFeed;
import com.google.gdata.data.photos.AlbumFeed;
import com.google.gdata.data.photos.UserFeed;

import java.net.URL;

public class Picasa {
    public static String USER = "anton.keks";

    PicasawebService service = new PicasawebService(USER);

    public UserFeed getGallery() {
        return feed("http://picasaweb.google.com/data/feed/api/user/" + USER + "?kind=album&thumbsize=160c", UserFeed.class);
    }

    public AlbumFeed getAlbum(String name) {
        return feed("http://picasaweb.google.com/data/feed/api/user/" + USER + "/album/" + name + "?imgmax=1024&thumbsize=144c", AlbumFeed.class);
        //return feed("http://picasaweb.google.com/data/feed/api/user/" + USER + "?kind=photo&q=" + name + "&imgmax=1024&thumbsize=144c", AlbumFeed.class);
    }

    private <T extends IFeed> T feed(String url, Class<T> type) {
        try {
            return service.getFeed(new URL(url), type);
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}