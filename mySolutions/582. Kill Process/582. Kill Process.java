class Solution {
    
    class Process {
        Integer pid;
        List<Integer> childPids;
        
        public Process() {
            pid = 0;
            childPids = new ArrayList<>();
        }
    }
    public List<Integer> killProcess(List<Integer> pids, List<Integer> ppids, int killPid) {
        Map<Integer, Process> map = new HashMap<>();
        
        for (int i = 0; i < pids.size(); i++) {
            int pid = pids.get(i);
            int ppid = ppids.get(i);
            
            if (!map.containsKey(pid)) {
                map.put(pid, new Process());
            }
            if (!map.containsKey(ppid)) {
                map.put(ppid, new Process());
            }
            
            map.get(ppid).childPids.add(pid);
        }
        
        List<Integer> result = new ArrayList<>();
        
        kill(map, killPid, result);
        return result;
    }
    
    private void kill(Map<Integer, Process> map, int pid, List<Integer> result) {
        result.add(pid);
        
        Process root = map.get(pid);
        if (root == null) {
            return;
        }
        
        for (Integer cpid : root.childPids) {
            kill(map, cpid, result);
        }
        
    }
}