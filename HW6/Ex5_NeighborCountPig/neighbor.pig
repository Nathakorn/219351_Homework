records = LOAD './web-Google.txt' USING PigStorage(' ') AS (fromNode: int, toNode: int);
fromTo = GROUP records by fromNode;
fromTo = FOREACH fromTo GENERATE records.fromNode AS k, records.toNode AS v, 'fromTo' AS type;
toFrom = GROUP records by toNode;
toFrom = FOREACH toFrom GENERATE records.toNode AS k, records.fromNode AS v, 'toFrom' AS type;
relations = UNION fromTo, toFrom;
relations = FOREACH relations GENERATE FLATTEN($0) AS k, $1 AS v, $2 AS type;

relations = GROUP relations by k;
DUMP relations;
-- DUMP fromTo;
-- results = FOREACH grouped GENERATE group, ;
-- DUMP results;
