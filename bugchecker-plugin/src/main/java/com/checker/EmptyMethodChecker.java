package com.checker;

import com.google.auto.service.AutoService;
import com.google.errorprone.BugPattern;
import com.google.errorprone.VisitorState;
import com.google.errorprone.BugPattern.SeverityLevel;
import com.google.errorprone.bugpatterns.BugChecker;
import com.google.errorprone.fixes.SuggestedFix;
import com.google.errorprone.matchers.Description;
import com.sun.source.tree.MethodTree;

@AutoService(BugChecker.class)
@BugPattern(name = "EmptyMethod", summary = "Empty method finded", severity = SeverityLevel.ERROR)
public class EmptyMethodChecker extends BugChecker implements BugChecker.MethodTreeMatcher {

    @Override
    public Description matchMethod(MethodTree tree, VisitorState state) {
        if (isMethodEmpty(tree)) {
            return suggestDeletion(tree);
        }
        return noAction();
    }

    private boolean isMethodEmpty(MethodTree tree) {
        return tree.getBody().getStatements().isEmpty();
    }

    private Description suggestDeletion(MethodTree tree) {
        return describeMatch(tree, SuggestedFix.delete(tree));
    }

    private Description noAction() {
        return Description.NO_MATCH;
    }
}
