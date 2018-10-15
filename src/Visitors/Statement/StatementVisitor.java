package Visitors.Statement;

import com.github.javaparser.ast.*;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class StatementVisitor extends VoidVisitorAdapter<Void> {
    public int count;

    public StatementVisitor() {
        this.count = 0;
    }

    public int getStatementCount() {
        return this.count;
    }

    public void visit(AssertStmt a, Void args) {
        this.count += 1;
    }

    public void visit(BreakStmt a, Void args) {
        this.count += 1;
    }

    public void visit(CatchClause a, Void args) {
        this.count += 1;
    }

    public void visit(ContinueStmt a, Void args) {
        this.count += 1;
    }

    public void visit(DoStmt a, Void args) {
        this.count += 1;
    }

    public void visit(EmptyStmt a, Void args) {
        this.count += 1;
    }

    public void visit(ExplicitConstructorInvocationStmt a, Void args) {
        this.count += 1;
    }

    public void visit(ExpressionStmt a, Void args) {
        this.count += 1;
    }

    public void visit(ForeachStmt a, Void args) {
        this.count += 1;
    }

    public void visit(ForStmt a, Void args) {
        this.count += 1;
    }

    public void visit(IfStmt a, Void args) {
        this.count += 1;
    }

    public void visit(LabeledStmt a, Void args) {
        this.count += 1;
    }

    public void visit(LocalClassDeclarationStmt a, Void args) {
        this.count += 1;
    }

    public void visit(ReturnStmt a, Void args) {
        this.count += 1;
    }

    public void visit(SwitchEntryStmt a, Void args) {
        this.count += 1;
    }

    public void visit(SwitchStmt a, Void args) {
        this.count += 1;
    }

    public void visit(SynchronizedStmt a, Void args) {
        this.count += 1;
    }

    public void visit(ThrowStmt a, Void args) {
        this.count += 1;
    }

    public void visit(TryStmt a, Void args) {
        this.count += 1;
    }

    public void visit(UnparsableStmt a, Void args) {
        this.count += 1;
    }

    public void visit(WhileStmt a, Void args) {
        this.count += 1;
    }
}
