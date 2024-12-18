package de.itestra.demo.action

import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys

class SearchStackoverflowAction : AnAction() {

    override fun getActionUpdateThread(): ActionUpdateThread {
        return ActionUpdateThread.EDT
    }

    override fun update(e: AnActionEvent) {
        val editor = e.getData(CommonDataKeys.EDITOR)
        val currentCaret = editor?.caretModel?.currentCaret
        val hasSelection = currentCaret?.hasSelection()
        e.presentation.isEnabledAndVisible = hasSelection!!
    }

    override fun actionPerformed(e: AnActionEvent) {
        val psiFile = e.getData(CommonDataKeys.PSI_FILE)
        val language = psiFile?.language
        val languageTag = "+[" + language?.displayName?.lowercase() + "]"
        val editor = e.getData(CommonDataKeys.EDITOR)
        val currentCaret = editor?.caretModel?.currentCaret
        val selectedText = currentCaret?.selectedText
        val query = selectedText?.replace(' ', '+') + languageTag
        BrowserUtil.browse("https:stackoverflow.com/search?q=$query")
    }
}