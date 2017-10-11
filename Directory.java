import java.io.File;
import java.util.ArrayList;
import java.util.List;


class Files {
    Directory directory;            //父目录

}

class Directory {
    List<File> files = new ArrayList<>();
    Directory father;
}

