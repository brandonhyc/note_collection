package codingPad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class FileSystem {
    Folder root;
    public FileSystem() {
        root = new Folder("$", "/");
    }

    public List<String> ls(String path) {
        Node node = find(root, 1, path);
        if (node instanceof File) {
            return Arrays.asList(node.name);
        }
        if (node instanceof Folder) {
            List<String> names = new ArrayList<>();
            for (Node child : ((Folder)node).children) {
                names.add(child.name);
            }
            Collections.sort(names);
            return names;
        }
        return null;
    }

    public void mkdir(String path) {
        make(path, root, "Folder");
    }

    private boolean make(String path, Node head, String type) {
        Node curr = head;
        int startIndex = 1;
        while (startIndex < path.length() && curr != null && curr instanceof Folder) {
            int endIndex = path.indexOf('/', startIndex + 1);
            if (endIndex == -1) {
                endIndex = path.length();
            }
            String subpath = path.substring(startIndex, endIndex);
            Node nextNode = null;
            for (Node child : ((Folder) curr).children) {
                if (child.name.equals(subpath)) {
                    nextNode = child;
                    break;
                }
            }

            if (nextNode == null) {
                if (endIndex == path.length()) {
                    nextNode = type.equals("File") ? new File(subpath, path, "") : new Folder(subpath, path);
                } else {
                    nextNode = new Folder(subpath, path);
                }
                ((Folder) curr).children.add(nextNode);
            }

            startIndex = endIndex + 1;
            curr = nextNode;
        }

        return true;
    }

    public void addContentToFile(String filePath, String content) {
        make(filePath, root, "File");

        File file = (File) find(root, 1, filePath);
        file.content += content;
    }

    public String readContentFromFile(String filePath) {
        Node target = find(root, 1, filePath);
        return target != null ? ((File) target).content: "-1";
    }

    private Node find(Folder head, int start, String path) {
        if (head == null || start > path.length() - 1) {
            return head;
        }
        // parse the sub-path for current level
        int endIndex = path.indexOf('/', start + 1);
        if (endIndex == -1) {
            endIndex = path.length();
        }
        String target = path.substring(start, endIndex);

        for (int i = 0; i < head.children.size(); i++) {
            Node child = head.children.get(i);
            if (child.name.equals(target)) {
                if (child instanceof Folder) {
                    return find((Folder) child, endIndex + 1, path);
                }
                return child;
            }
        }

        return null;
    }

    private class Node {
        String name = null;
        int size = 0;
        String path = null;

        public Node(String name, String path) {
            this.name = name;
            this.path = path;
        }
    }

    private class File extends Node {
        String content;

        public File(String name, String path, String content) {
            super(name, path);
            this.content = content;
        }
    }

    private class Folder extends Node {
        List<Node> children;

        public Folder(String name, String path) {
            super(name, path);
            this.children = new ArrayList<>();
        }
    }

}