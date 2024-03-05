import java.util.Comparator;

class Node<E> {
    E value;
    /*
     *  부모 노드는 BinarySearchTree에서는 당장 쓰이진 않으나
     *  추후 용이하게 쓰이니 미리 부모노드를 가리키는 변수도 같이
     *  구현하면서 익숙해지는 것이 좋다.
     */
    Node<E> left;
    Node<E> right;
    Node<E> parent;

    Node(E value) {
        this(value, null);
    }

    Node(E value, Node<E> parent) {
        this.value = value;
        this.parent = parent;
        this.right = null;
        this.left = null;
    }

}

public class BST<E> {
    private Node<E> root;	// 루트(최상단) 노드
    private int size;		// 요소(노드)의 개수

    private final Comparator<? super E> comparator;

    public BST() {
        this(null);
    }
    public BST(Comparator<? super E> comparator) {
        this.comparator = comparator;
        this.root = null;
        this.size = 0;
    }



    public boolean add(E value) {

        /*
         * comparator(사용자 지정 비교기)가 없을 경우(=null)에는 Comparable,
         * 있을 경우에는 Comparator를 사용하는 메소드로 보낸다.
         * 그리고, 각 메소드는 정상적으로 삽입이 완료되었다면 null을 반환할 것이고,
         * 중복 원소를 삽입 할 경우 해당 value를 반환할 것이기 때문에
         * 비교 연산으로 null인지 아닌지 여부를 반환한다.
         */
        if(comparator == null) {
            return addUsingComparable(value) == null;
        }
        return addUsingComparator(value, comparator) == null;
    }

    // Comparable을 이용한 add메소드
    private E addUsingComparable(E value) {

        Node<E> current = root; // 탐색할 노드를 가리키는 current node

        // 만약 current가 null, 즉 root가 null이면 root에 새 노드를 만들고 null반환
        if(current == null) {
            root = new Node<E>(value);
            size++;
            return null;
        }

        Node<E> currentParent;	// current의 직전 탐색 노드를 가리키는 노드

        // 삽입 할 노드가 비교 될 수 있도록 한 변수를 만든다.
        @SuppressWarnings("unchecked")
        Comparable<? super E> compValue = (Comparable<? super E>) value;

        int compResult;	// 비교 결과(양수, 0, 음수)를 담고 있을 변수

        do {
            // 다음 순회에서 current의 부모노드를 가리킬 수 있도록 현재 current를 저장
            currentParent = current;

            compResult = compValue.compareTo(current.value);

            /*
             * 비교 결과 value 보다 current.value 가 작으면
             * current를 current의 왼쪽 자식으로 갱신하고,
             * value 보다 current.value 가 크다면 current 를 오른쪽
             * 자식으로 갱신하며, 같을 경우 순회를 중단하고 value 를 반환한다.
             */
            if(compResult < 0) {
                current = current.left;
            } else if(compResult > 0) {
                current = current.right;
            }
            else {
                return value;
            }

        } while(current != null);


        // 순회가 완료되어 삽입해야 할 위치를 찾았다면 삽입 할 value를 노드로 만든다.
        Node<E> newNode = new Node<E>(value, currentParent);

        // 직전 비교 결과에 따라 currentParent의 오른쪽 혹은 왼쪽 노드에 새 노드를 연결해준다.
        if(compResult < 0) {
            currentParent.left = newNode;
        }
        else {
            currentParent.right = newNode;
        }

        size++;
        return null;
    }

    // Comparator을 이용한 add
    private E addUsingComparator(E value, Comparator<? super E> comp) {

        Node<E> current = root;
        if(current == null) {
            root = new Node<E>(value, null);
            size++;
            return null;
        }

        Node<E> currentParent;
        int compResult;
        do {
            currentParent = current;
            compResult = comp.compare(value, current.value);
            if(compResult < 0) {
                current = current.left;
            }
            else if(compResult > 0) {
                current = current.right;
            }
            else {
                return value;
            }
        } while(current != null);

        Node<E> newNode = new Node<E>(value, currentParent);
        if(compResult < 0) {
            currentParent.left = newNode;
        }
        else {
            currentParent.right = newNode;
        }
        size++;
        return null;
    }

    /**
     * 삭제 메소드
     * @param o 삭제할 값
     * @return 삭제 된 노드의 value 값 혹은 매칭 값이 없을 경우 null을 반환한다.
     */
    public E remove(Object o) {

        if (root == null) {
            return null;
        }
        if (comparator == null) {
            return removeUsingComparable(o);
        } else {
            return removeUsingComparator(o, comparator);
        }
    }

    /**
     * Comparable을 이용한 데이터 삭제
     *
     * @param value 삭제하고자 하는 데이터
     * @return 정상적으로 삭제되었을 경우 value를 반환하나, 삭제할 노드가 없을경우 null을 반환한다.
     */
    private E removeUsingComparable(Object value) {
        @SuppressWarnings("unchecked")
        E oldVal = (E) value;
        Node<E> parent = null, current = root;
        boolean hasLeft = false;

        if (root == null) {
            return null;
        }

        @SuppressWarnings("unchecked")
        Comparable<? super E> compValue = (Comparable<? super E>) value;

        do {
            int resComp = compValue.compareTo(current.value);
            if (resComp == 0) {
                break;
            }

            parent = current;
            if (resComp < 0) {
                hasLeft = true;
                current = current.left;
            } else {
                hasLeft = false;
                current = current.right;
            }
        } while (current != null);

        if (current == null) {
            return null;
        }

        if (parent == null) {
            deleteNode(current);
            size--;
            return oldVal;
        }

        if (hasLeft) {
            parent.left = deleteNode(current);
            if (parent.left != null) {
                parent.left.parent = parent;
            }
        }
        else {
            parent.right = deleteNode(current);
            if (parent.right != null) {
                parent.right.parent = parent;
            }
        }
        size--;
        return oldVal;
    }

    /**
     * Comparator을 이용한 데이터 삭제
     *
     * @param value 삭제하고자 하는 데이터
     * @return 정상적으로 삭제되었을 경우 value를 반환하나, 삭제할 노드가 없을경우 null을 반환한다.
     */
    private E removeUsingComparator(Object value, Comparator<? super E> comp) {
        @SuppressWarnings("unchecked")
        E oldVal = (E) value;
        Node<E> parent = null, current = root;
        boolean hasLeft = false;
        if (root == null) {
            return null;
        }

        @SuppressWarnings("unchecked")
        E compValue = (E) value;

        do {
            int resComp = comp.compare(compValue, current.value);
            if (resComp == 0) {
                break;
            }

            parent = current;
            if (resComp < 0) {
                hasLeft = true;
                current = current.left;
            } else {
                hasLeft = false;
                current = current.right;
            }
        } while (current != null);

        if (current == null) {
            return null;
        }

        if (parent == null) {
            deleteNode(current);
            size--;
            return oldVal;
        }

        if (hasLeft) {
            parent.left = deleteNode(current);
            if (parent.left != null) {
                parent.left.parent = parent;
            }
        } else {
            parent.right = deleteNode(current);
            if (parent.right != null) {
                parent.right.parent = parent;
            }
        }
        size--;
        return oldVal;
    }

    /**
     * 삭제 할 노드에 대해 삭제를 수행하는 메소드
     *
     * @param node 삭제 할 노드
     * @return 삭제 후 대체 되고 난 뒤의 해당 위치의 노드를 반환
     */
    private Node<E> deleteNode(Node<E> node) {

        if (node != null) {
            if (node.left == null && node.right == null) {
                if (node == root) {
                    root = null;
                }
                else {
                    node = null;
                }
                return null;
            }

            if (node.left != null && node.right != null) {
                Node<E> replacement = getSuccessorAndUnlink(node);
                node.value = replacement.value;
            }
            else if (node.left != null) {
                if (node == root) {
                    node = node.left;
                    root = node;
                    root.parent = null;
                } else {
                    node = node.left;
                }
            } else {
                if (node == root) {
                    node = node.right;
                    root = node;
                    root.parent = null;
                } else {
                    node = node.right;
                }
            }
        }

        return node;
    }

    /**
     * 삭제되는 노드의 자리를 대체할 노드(후계자)를 찾는 메소드
     * (오른쪽 자식 노드 중 가장 작은 노드를 찾음)
     *
     * @param node 삭제되는 노드(=대체되어야 할 노드)
     * @return 대체할 노드
     */
    private Node<E> getSuccessorAndUnlink(Node<E> node) {

        Node<E> currentParent = node;
        Node<E> current = node.right;

        if (current.left == null) {
            currentParent.right = current.right;
            if (currentParent.right != null) {
                currentParent.right.parent = currentParent;
            }
            current.right = null;
            return current;
        }

        while (current.left != null) {
            currentParent = current;
            current = current.left;
        }

        currentParent.left = current.right;
        if (currentParent.left != null) {
            currentParent.left.parent = currentParent;
        }

        current.right = null;
        return current;
    }
}
