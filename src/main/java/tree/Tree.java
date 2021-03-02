package tree;

import java.util.*;
import java.util.function.Predicate;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    private Node<E> findByPredicate(Predicate<Node<E>> condition) {
        Queue<SimpleTree.Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            SimpleTree.Node<E> el = data.poll();
            if (condition.test(el)) {
                return el;
            }
            data.addAll(el.children);
        }
        return null;
    }

    public boolean isBinary() {
       if (findByPredicate(n -> n.children.size() > 2) == null) {
           return true;
       }
       return false;
    }

    @Override
    public boolean add(E parent, E child) {
        Node<E> prntNode = findBy(parent).orElse(null);
        if (prntNode == null) {
            return false;
        }
        return prntNode.children.add(new Node<>(child));
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}