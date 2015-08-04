package com.jamesneve.christmas

abstract class Presenter[caseClass] {
	protected val obj : caseClass

	protected def autoLink(text: String) = {
		val validUrlRegex = """(?:https?:\/\/)(?:[\w]+\.)(?:\.?[\w]{2,})+""".r
		validUrlRegex replaceAllIn(text, "<a href=\"$0\">$0</a>")
	}

	protected def autoEmail(text: String) = {
		val validEmailRegex = """[\w+\-.]+@[a-z\d\-.]+\.[a-z]+""".r
		validEmailRegex replaceAllIn(text, "<a href=\"mailto:$0\">$0</a>")
	}
}
