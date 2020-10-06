def oldestAncestor(pairs, source):
    m = defaultdict(list)
    
    for parent, child in pairs:
        m[child].append(parent)

    globalMax = (0, None)

    search(source, m, globalMax)

    return globalMax[1] if globalMax[1] is not None


def search(child, distance, m, globalMax):
    if len(m[child]) == 0:
        return 
    if distance > globalMax[0]:
        globalMax[0] = distance
        globalMax[1] = child

    for parent in m[child]:
        search(parent, distance + 1, m, globalMax)
        