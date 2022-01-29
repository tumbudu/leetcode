-module(find_duplicate_subtrees).

-define(DBG(X),io:format("~p~n", [X])).

%% # 652
%% # https://leetcode.com/problems/find-duplicate-subtrees/


%% Definition for a binary tree node.
%%
%% -record(tree_node, {val = 0 :: integer(),
%%                     left = null  :: 'null' | #tree_node{},
%%                     right = null :: 'null' | #tree_node{}}).

-spec find_duplicate_subtrees(Root :: #tree_node{} | null) -> [#tree_node{} | null].
find_duplicate_subtrees(Root) ->
    {_RootSign, SignDict, SignTreeDict} = traverse(Root, dict:new(), dict:new()),
    SignList = dict:fetch_keys(SignDict),
    
    FSignList = lists:filter(fun(K) ->
        {ok, Ctr} = dict:find(K, SignDict), Ctr > 1
    end, SignList),
    
    lists:map(fun(K) ->
        {ok, T} = dict:find(K, SignTreeDict),T
    end, FSignList).

traverse(null, SignDict, SignTreeDict) ->
    {"", SignDict, SignTreeDict};
    
traverse(Root, SignDict, SignTreeDict) ->
    {RSign, RSignDict, RSignTreeDict} = traverse(Root#tree_node.left, SignDict, SignTreeDict),
    {LSign, LSignDict, LSignTreeDict} = traverse(Root#tree_node.right, RSignDict, RSignTreeDict),
    Sign = integer_to_list(Root#tree_node.val) ++"-" ++RSign ++ "-"++ LSign,
    %?DBG(Sign),
    {
     Sign,
     dict:update_counter(Sign, 1, LSignDict),
     dict:store(Sign, Root, LSignTreeDict)
    }.
        
