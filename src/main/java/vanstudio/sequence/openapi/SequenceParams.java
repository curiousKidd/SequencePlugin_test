package vanstudio.sequence.openapi;

import vanstudio.sequence.openapi.filters.CompositeElementFilter;
import vanstudio.sequence.openapi.filters.ImplementationWhiteList;

public class SequenceParams {
    public static final String PACKAGE_INDICATOR = ".*";
    public static final String RECURSIVE_PACKAGE_INDICATOR = ".**";

    private int _maxDepth = 3;
    private boolean _allowRecursion = false;
    private final CompositeElementFilter _methodFilter = new CompositeElementFilter();
    private final ImplementationWhiteList _implFilter = new ImplementationWhiteList();

    public SequenceParams() {
    }

    public int getMaxDepth() {
        return _maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this._maxDepth = maxDepth;
    }

    public boolean isNotAllowRecursion() {
        return !_allowRecursion;
    }

    public void setAllowRecursion(boolean allowRecursion) {
        this._allowRecursion = allowRecursion;
    }

    public CompositeElementFilter getMethodFilter() {
        return _methodFilter;
    }

    public ImplementationWhiteList getImplementationWhiteList() {
        return _implFilter;
    }
}

