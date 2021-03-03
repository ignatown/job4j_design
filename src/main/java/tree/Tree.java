package tree;

import java.util.*;
import java.util.function.Predicate;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Queue<SimpleTree.Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            SimpleTree.Node<E> el = data.poll();
            if (condition.test(el)) {
                return Optional.of(el);
            }
            data.addAll(el.children);
        }
        return Optional.empty();
    }

    public boolean isBinary() {
        return !findByPredicate(n -> n.children.size() > 2).isPresent();
    }


    @Override
    public boolean add(E parent, E child) {
        Node<E> prntNode = findBy(parent).orElse(null);
        if (prntNode == null) {
            return false;
        }
        if (findBy(child).isPresent()) {
            return false;
        }
        return prntNode.children.add(new Node<>(child));
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(el -> el.value.equals(value));
    }
}