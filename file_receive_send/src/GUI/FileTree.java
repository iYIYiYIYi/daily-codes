package GUI;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class FileTree extends JPanel {
    private JTree tree;
    private TreePath treePath;

    public FileTree() {
        this.setLayout(new BorderLayout());
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Explorer");
        tree = new JTree(root);
        File[] roots = File.listRoots();
        for (int i = 0; i < roots.length; i++) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(roots[i].getPath());
            root.add(node);
        }
        MouseListener ml = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                try {
                    TreePath tp = tree.getPathForLocation(e.getX(), e.getY());
                    if (tp != null) {
                        treePath = tp;
                        int size = treePath.getPath().length;
                        StringBuffer pathname = new StringBuffer();
                        if (size > 0) {
                            for (int i = 1; i < size; i++) {
                                if (i > 2) {
                                    pathname.append("//");
                                }
                                pathname.append(treePath.getPath()[i].toString());

                            }
                            System.out.println(pathname.toString());
                            File file = new File(pathname.toString());
                            File[] list = file.listFiles();
                            for (int i = 0; i < list.length; i++) {
                                String[] strings = list[i].getPath().split("////");
                                DefaultMutableTreeNode node = new DefaultMutableTreeNode(strings[strings.length - 1]);
                                ((DefaultMutableTreeNode) tp.getLastPathComponent()).add(node);
                            }
                        }
                    }
                } catch (Exception e1) {
                    System.out.println("can not open");
                }
            }
        };
        tree.addMouseListener(ml);
        tree.setShowsRootHandles(true);
        tree.setRootVisible(true);
        JScrollPane scrPane = new JScrollPane(tree);
        add(scrPane);
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Explorer");
        jFrame.setLayout(new BorderLayout());
        jFrame.add(new FileTree());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(300, 700);
        jFrame.setVisible(true);
    }
}