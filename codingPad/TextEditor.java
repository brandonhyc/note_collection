package codingPad;

import java.util.*;

public class TextEditor {
    StringBuilder curr = new StringBuilder();
    ArrayDeque<List<String>> historyStack = new ArrayDeque<>();
    ArrayDeque<List<String>> restoreStack = new ArrayDeque<>();
    int[] range;

    public String solve(List<List<String>> input) {
        Collections.sort(input, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> a, List<String> b) {
                return Integer.compare(Integer.parseInt(a.get(0)), Integer.parseInt(b.get(0)));
            }
        });

        for (List<String> arg : input) {
            process(arg);
        }

        return curr.toString();
    }

    private void select(List<String> arg) {
        int start = Integer.parseInt(arg.get(2)), end = Math.max(Integer.parseInt(arg.get(3)), curr.length());
        if (start >= curr.length() || start >= end) {
            return; // invalid
        } else {
            range = new int[] {start , end};
        }
    }

    private void resetRange() {
        range = null;
    }

    private void process(List<String> arg) {
        String cmd = arg.get(1);
        if ("APPEND".equals(cmd)) {
            String _var = arg.get(2);
            append(_var);
            historyStack.offerFirst(arg);
            resetRange();
        } else if ("BACKSPACE".equals(cmd)) {
            String removed = backspace();
            List<String> en = Arrays.asList(arg.get(0), arg.get(1), removed);
            historyStack.offerFirst(en);
            resetRange();
        } else if ("SELECT".equals(cmd)) {
            select(arg);
        } else if ("UNDO".equals(cmd)){
            undo();
        } else if ("REDO".equals(cmd)) {
            redo();
        } else if ("BOLD".equals(cmd)) {
            bold();
            List<String> end = Arrays.asList(arg.get(0), arg.get(1), String.valueOf(range[0]), String.valueOf(range[1]));
            historyStack.offerFirst(arg);
            resetRange();
        } else {
            return;
        }
    }

    private void redo() {
        List<String> arg = restoreStack.pollFirst();
        process(arg);
    }
    private void undo() {
        List<String> arg = historyStack.pollFirst();
        String cmd = arg.get(1);
        if ("APPEND".equals(cmd)) {
            String _var = arg.get(2);
            curr.setLength(curr.length() - _var.length());

        } else if ("BACKSPACE".equals(cmd)) {
            String _var = arg.get(2);
            curr.append(_var);
        } else if ("BOLD".equals(cmd)) {
            unbold(arg);
        } else {
            return;
        }
        restoreStack.offerFirst(arg);
        resetRange();
    }

    private void unbold(List<String> arg) {
        int start = Integer.parseInt(arg.get(2)), end = Integer.parseInt(arg.get(3)) ;
        curr.deleteCharAt(start);
        curr.deleteCharAt(end + 1);
        // 0  1 2 3 4
        // a   bc
    }

    private String backspace() {
        int start = curr.length() - 1, end = curr.length();
        if (range != null) {
            start = range[0];
            end = range[1];
        }
        String removed = curr.substring(start, end);
        curr.delete(start, end);
        return removed;
    }

    private void append(String _var) {
        if (range != null) {
            backspace();
            int start = range[0];
            curr.insert(start, _var);
        } else {
            curr.append(_var);
        }
    }

    private void bold() {
        if (range == null) return;
        curr.insert(range[0], "");
        curr.insert(range[1], "");
    }

//    append, backspace, undo, redo, select, bold
}
