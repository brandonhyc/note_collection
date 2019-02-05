### What is Flux
Unidrectional application flow paradigm. Data flows in one direction from view triggering action to dispatcher, then to stores and being kept by stores, and finally re-rendered to the view.

+----------------+----+--------+----+----------+----+----------+----+--------------+
| Action Creator | -> | Action | -> | Dispatch | -> | Reducers | -> | State(Store) |
+----------------+----+--------+----+----------+----+----------+----+--------------+
 call          produces        get fed to   forward it to        create new
