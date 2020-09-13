
def hasLCA(graph, root, A, B) -> bool :
    
    m = defaultdict(list)
    degree = {}
    degree = defaultdict(lambda a:0, degree)

    entries = []
    # build graph
    for parent, child in graph:
        m[parent].append(child)
        degree[child] += 1
    
    for parent, child in graph:
        if degree[parent] == 0:
            entries.append(parent)
    
    for en in entries:
        hasAB = (False, False)
        lca = findLCA(en, A, B, hasAB, m)

        if res in hasAB:
            if not res:
                return None
        return lca 


def findLCA(root, A, B, hasAB, m) -> object:
    if root is None:
        return None
    
    found = 0
    if root == A:
        found += 1
        hasAB[0] = True
    if root == B:
        found += 1
        hasAB[1] = True
    
    finding = None
    for node in m[root]:
        finding = findLCA(node, A, B, hasAB, m)
        if finding:
            found += 1
    
    if found == 2:
        return root
    if found == 1:
        return finding

    return None