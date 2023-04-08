import java.util.Iterator;

public class MyList implements Iterable {
    private Node start;
    private Node finish;
    private int count = 0;

    @Override
    public Iterator<Object> iterator(){
        return new Iterator<Object>() {
            Node node0 = new Node("0");
            {
                node0.setNextNode(start);
            }

            Node node = node0;

            @Override
            public boolean hasNext() {
                return node.getNextNode() != null;
            }

            @Override
            public Object next() {
                node = node.getNextNode();
                return node.getData();
            }
        };
    }

    public int size() {
        return count;
    }
    private Node getNode(int index){
        if (index >= count){
            throw new IndexOutOfBoundsException();
        }

        Node result = start;
        for (int i = 1; i <= index; i++){
            result = result.getNextNode();
        }
        return result;
    }

    public Object get(int index){

        Node node = getNode(index);

        return node.getData();
    }

    public void remove(int index){

        Node node = getNode(index);
        Node nextNode = node.getNextNode();
        Node prevNode = node.getPrevNode();

        if (index == 0){
            start = nextNode;
            if (finish == node){
                finish = null;
            }
        }

        if (index == count - 1){
            finish = prevNode;
            if (start == node){
                start = null;
            }
        }

        count--;

        if (nextNode != null){
            nextNode.setPrevNode(prevNode);
        }

        if (prevNode != null){
            prevNode.setNextNode(nextNode);
        }

    }

    public void add(int index, Object data){
        if (count == index){
            add(data);
            return;
        }
        count++;

        Node node = new Node(data);

        if (index == 0){
            start = node;
        }

        Node nextNode = getNode(index);
        Node prevNode = nextNode.getPrevNode();

        node.setNextNode(nextNode);
        node.setPrevNode(prevNode);

        if (prevNode != null) {
            prevNode.setNextNode(node);
        }

    }

    public void add(Object data){
        count++;
        Node node = new Node(data);
        if (start == null){
            start = node;
            finish = node;
            return;
        } else if (finish == null) {
            finish = node;
            return;
        }

        finish.setNextNode(node);
        node.setPrevNode(finish);
        finish = node;
    }

}