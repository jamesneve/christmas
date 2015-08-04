package com.jamesneve.christmas

import org.scalatest.{WordSpec, MustMatchers}

// Test data simulating real data
case class TestClass(id: Int, name: String, email: String, website: String)

class TestPresenter(testClass: TestClass) extends Presenter[TestClass] {
	protected val obj = testClass

	def name = "Name: " + obj.name

	def email = autoEmail(obj.email)

	def website = autoLink(obj.website)
}

class PresenterSpec extends WordSpec with MustMatchers {
	val testClass = TestClass(1, "James", "james@mail.com", "http://www.james.com")

	"Presenter" must {
		val presenter = new TestPresenter(testClass)

		"return basic methods correctly" in {
			presenter.name mustBe "Name: James"
		}

		"auto-link emails" in {
			presenter.email mustBe "<a href=\"mailto:james@mail.com\">james@mail.com</a>"
		}

		"auto-link websites" in {
			presenter.website mustBe "<a href=\"http://www.james.com\">http://www.james.com</a>"
		}
	}
}
