//
// Topological Sort, Hash Table, Graph, Array, String(Find All Possible Recipes from Given Supplies)
// https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
// Created by hyungwook on 2022/06/30.
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> supply = Arrays.stream(supplies).collect(Collectors.toSet());
        HashMap<String, Integer> isVisit = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            map.put(recipes[i], i);
            isVisit.put(recipes[i], 0);
        }
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];

            if (dfs(supply, isVisit, map, recipe, ingredients)) {
                answer.add(recipe);
            }
        }

        return answer;
    }

    private boolean dfs(Set<String> supply, HashMap<String, Integer> isVisit, HashMap<String, Integer> map, String recipe, List<List<String>> ingredients) {
        if (!isVisit.containsKey(recipe)) {
            if (supply.contains(recipe)) {
                return true;
            } else {
                return false;
            }
        }
        if (isVisit.get(recipe) == 2) {
            return true;
        }
        if (isVisit.get(recipe) == 1) {
            return false;
        }
        isVisit.put(recipe, 1);

        for (String ingredient : ingredients.get(map.get(recipe))) {
            if (!dfs(supply, isVisit, map, ingredient, ingredients)) {
                return false;
            }
        }

        isVisit.put(recipe, 2);
        return true;
    }
}