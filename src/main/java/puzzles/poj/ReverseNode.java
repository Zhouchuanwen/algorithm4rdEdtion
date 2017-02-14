package puzzles.poj;

/**
 * Created by alan on 17/2/9.
 */
public class ReverseNode {

    /**
     * 单链表反转
     */
    private ReverseNode next;

    private String value;

    public ReverseNode getNext() {
        return next;
    }

    public void setNext(ReverseNode next) {
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void reverse(ReverseNode head){
        if (head!=null){
            ReverseNode nextNode=head.getNext();
            if (nextNode!=null){
                reverse(nextNode);
                nextNode.setNext(head);
            }
        }
    }














}
